package com.staff.Action;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.print.DocFlavor.STRING;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.staff.common.Action;
import com.staff.controller.Dao.AllDao;
import com.staff.controller.Dao.PageDao;
import com.staff.controller.Dto.PageDto;
import com.staff.controller.Dto.ProjectDto;

public class Pj_History_InsertAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		//관리자와 일반사원 구분해야합니다.
		//경고창 뛰우기
		String url = "side_bar/pj_History_List.jsp";
		
		ProjectDto prodto = new ProjectDto();
		
		prodto.setPcontent(request.getParameter("pcontent"));
		prodto.setPro_nm(request.getParameter("pro_nm"));
		prodto.setProend(request.getParameter("proend"));
		prodto.setProsta(request.getParameter("prostr"));
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String empno = (String) session.getAttribute("empno");
		
		prodto.setId(id);
		//세션 아이디를 가지고 와서 등록합니다.
		
		AllDao prodao = AllDao.getInstance();
		//프로젝트 insert
		int result = prodao.proinsert(prodto);
		//프로젝트 현 넘버 가져오기
		int pronum = prodao.pronoSelect();
		
		if(result == 1) {
			//스킬 배열 체크박스 가지고옴
			String[] sknum = request.getParameterValues("sknum");
			
			//셀렉문 추가 prono값 가져오기위해서이다.
			
			for (int i =0; i < sknum.length; i++) {
				//체크박스에 저장된 값을 하나하나 db에 저장
				String sk = sknum[i];
				prodao.prosknum(pronum, sk);
				
			}
			//수행스킬 넘버 가지고 옴
			String rolenum = request.getParameter("rolenum");
			prodao.proRolenumInsert(rolenum, empno, pronum);
			
		}
	
		
		//페이징 시작
		PageDao dao = PageDao.getInstance();
		//다오 SelectAll 실행(dto에 id에 따른 정보값 가지고 오기)
		//페이징시작
	    String pageNum = request.getParameter("pageNum");//페이지 번호
	    	if (pageNum == null) {
	    		pageNum = "1";
	        } 
	   
	    	
		int totalRecord = dao.proPage();
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
		//리스트 뽑아주는 프로리스트 
		ArrayList proL = dao.proList(dto.getStart(),dto.getEnd());
		
		request.setAttribute("Dto", dto);
		System.out.println(dto);
		request.setAttribute("ProL", proL);//값이 없음
		System.out.println(proL);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
