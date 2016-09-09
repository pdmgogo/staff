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

public class staff_History_Update implements Action {

	@Override
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		String url = "side_bar/staff_History_View.jsp";
		//세션 생성
		HttpSession session = request.getSession();
		//세션에 있는 아이디값을 id로 저장
		String id = (String) session.getAttribute("id");
		EmpDto dto = new EmpDto();
		dto.setId(id);
		dto.setDeptno(request.getParameter("deptno"));
		dto.setJobno(request.getParameter("jobno"));
		dto.setPwd(request.getParameter("pwd"));
		dto.setEmpl_nm(request.getParameter("empl_nm"));
//		dto.setFjumin(request.getParameter("fjumin"));
//		dto.setBjumin(request.getParameter("bjumin"));
		dto.setHiredate(request.getParameter("hiredate"));
		dto.setResigndate(request.getParameter("resigndate"));
		dto.setEmail(request.getParameter("email"));
		dto.setZip_cd(request.getParameter("zip_cd"));
		dto.setAddr(request.getParameter("addr"));
		dto.setDeaddr(request.getParameter("deaddr"));
		dto.setSal(Integer.parseInt(request.getParameter("sal")));
		dto.setEtc(request.getParameter("etc"));
		dto.setEregdate(request.getParameter("eregdate"));
		
//		AllDto dept_dto = new AllDto();
//		dept_dto.setAdmin(request.getParameter("dept_nm"));
//		dept_dto.setAdmin(request.getParameter("dept_no"));
//		
//		AllDto job_dto = new AllDto();
//		job_dto.setAdmin(request.getParameter("job_nm"));
//		job_dto.setAdmin(request.getParameter("job_no"));
		
		AllDao dao = AllDao.getInstance();
		dao.updateEmp(dto);
		
		//세션에 있는 아이디값을 id로 저장
		String empno = (String) session.getAttribute("empno");

		EmpDto empdto = dao.SelectAll(empno);
		
		//dto를 dto란 이름으로 리퀘스트에 넣기
		request.setAttribute("Dto", empdto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		
		dispatcher.forward(request, response);

	}

}
