package com.staff.Action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.staff.common.Action;
import com.staff.controller.Dao.AllDao;

import com.staff.controller.Dto.EmpDto;

public class Staff_History_UpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		//관리자와 사원 구분 해야합니다.
		//경고창 뛰우기
		String url = "side_bar/staff_History_Update.jsp";
		//세션 생성
		HttpSession session = request.getSession();
		//세션에 있는 아이디값을 id로 저장
		String empno = (String) session.getAttribute("empno");
		//다오 인스턴스 생성(그외 테이블 다오 생성준비)
		AllDao dao = AllDao.getInstance();
		//다오 SelectAll 실행(dto에 id에 따른 정보값 가지고 오기)
		EmpDto empdto = dao.SelectAll(empno);
//		DeptDto dept_dto = dao.SelectDeptAll(id);
//		JobDto job_dto = dao.SelectJobAll(id);
		//dto를 dto란 이름으로 리퀘스트에 넣기
		System.out.println(empdto);
		request.setAttribute("Dto", empdto);
//		request.setAttribute("dept_dto", dto);
//		request.setAttribute("job_dto", dto);
	
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
