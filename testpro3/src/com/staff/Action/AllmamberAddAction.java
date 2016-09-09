package com.staff.Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import com.staff.common.Action;
import com.staff.controller.Dao.AllDao;
import com.staff.controller.Dto.EmpDto;

public class AllmamberAddAction implements Action {

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response) 
					throws ServletException, IOException {
//		int empno = Integer.parseInt(request.getParameter("empno"));
		String empl_nm = 	request.getParameter("empl_nm");
		String id = 		request.getParameter("id");
		String email = 		request.getParameter("email");
		String pwd = 		request.getParameter("pwd");
		String fjumin = 	request.getParameter("fjumin");
		String bjumin = 	request.getParameter("bjumin");
		
		EmpDto dto = new EmpDto();
		//System.out.println(dto);
//		dto.setEmpno(empno);
		dto.setEmpl_nm(empl_nm);
		dto.setPwd(pwd);
		dto.setEmail(email);
		dto.setId(id);
		dto.setFjumin(fjumin);
		dto.setBjumin(bjumin);
		AllDao dao = AllDao.getInstance();
//		//다오 수정
		
		int result = dao.insertMember(dto);
//		System.out.println(result);
		//사번처리
//		if (result == 1) {
//			dto = dao.empnoInsert();
//		}
		
		JsonObject json = new JsonObject();
//		json.addProperty("empno", dto.getEmpno());
		json.addProperty("empl_nm", dto.getEmpl_nm());
		json.addProperty("id", dto.getId());
		json.addProperty("email", dto.getEmail());
		json.addProperty("pwd", dto.getPwd());
		json.addProperty("fjumin", dto.getFjumin());
		json.addProperty("bjumin", dto.getBjumin());
		
		response.setContentType("charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
//		dao.insertMember(dto);
//		response.sendRedirect("MemberServlet?command=memberList");
		
	}

}
