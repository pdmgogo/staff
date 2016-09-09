package com.staff.Action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import com.staff.common.Action;
import com.staff.controller.Dao.AllDao;
import com.staff.controller.Dao.PageDao;
import com.staff.controller.Dto.PageDto;
import com.staff.controller.Dto.noticeDto;

public class NoticeInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		//관리자 확인
		String url = "side_bar/notice.jsp";
	
		noticeDto nodto = new noticeDto();
		
		nodto.setNotcon(request.getParameter("notcon"));
		nodto.setNot_nm(request.getParameter("not_nm"));
		//세션 id값 가지고 오기
		HttpSession session = request.getSession();
		String empno= (String) session.getAttribute("empno");
		nodto.setEmpno(empno);
//		String empl_nm = (String) session.getAttribute("empl_nm");
		
		AllDao padao = AllDao.getInstance();
		
		padao.noticeInsert(nodto);
		
		PageDao dao = PageDao.getInstance();
		//다오 SelectAll 실행(dto에 id에 따른 정보값 가지고 오기)
		//페이징시작
	    String pageNum = request.getParameter("pageNum");//페이지 번호
	    	if (pageNum == null) {
	    		pageNum = "1";
	        } 
	   
	    	
		int totalRecord = dao.noticePage();
		PageDto dto = new PageDto();
		int numPerPage = 3;
		int curPage = Integer.parseInt(pageNum);
		System.out.println("curPage : "+curPage);
		int pagePerBlock = 3;
		dto.setCurPage(curPage);
		dto.setTotalRecord(totalRecord);
		dto.setPagePerBlock(pagePerBlock);
		dto.setNumPerPage(numPerPage);
		dto.setTotalPage();
		dto.setBlock();
		dto.setStart();
		dto.setEnd();
		dto.setFirstPage();
		dto.setLastPage();
		dto.setTotalBlock();
		dto.setPrevPage();
		dto.setNextPage();
		ArrayList noticeL = dao.noticeList(dto.getStart(),dto.getEnd());
		
		
		request.setAttribute("Dto", dto);
		
		request.setAttribute("List", noticeL);
		
	
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		

	}

}
