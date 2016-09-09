package com.staff.Action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;


import com.staff.common.Action;
import com.staff.controller.Dao.AllDao;
import com.staff.controller.Dao.PageDao;
import com.staff.controller.Dto.EmpDto;
import com.staff.controller.Dto.PageDto;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		String url = "mainView/main.jsp";
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
//		System.out.println(" id " + id + " pwd " +pwd);
		AllDao empdao = AllDao.getInstance();
		int result = empdao.logincheck(id,pwd);
		System.out.println(result);
		if(result == 1) {
			System.out.println("로그인에 성공하셧습니다.");
//			회원가입한 id로 dto로 말아서 처음 정보 가지고 오기
			
			EmpDto dto = empdao.StartJoinStaff(id);
//			세션 생성-> 아이디/이름 저장
			HttpSession session = request.getSession();
			session.setAttribute("empno", dto.getEmpno());
			session.setAttribute("id", dto.getId());
			session.setAttribute("empl_nm", dto.getEmpl_nm());
			request.setAttribute("message", dto.getEmpno()); 
			//			세션 생성 종료
		} else if (result ==0) {
			System.out.println("비밀번호가 틀렸습니다.");
			url="index.jsp";
		} else {
			System.out.println("다시 확인 부탁합니다.");
			url="index.jsp";
		}
		
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
