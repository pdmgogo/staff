package com.staff.Action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.staff.common.Action;
import com.staff.controller.Dao.PageDao;
import com.staff.controller.Dto.PageDto;

public class MainAction implements Action {

	@Override
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		String url = "mainView/main.jsp";
		
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
