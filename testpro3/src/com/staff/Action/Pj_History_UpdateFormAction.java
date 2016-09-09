package com.staff.Action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.staff.common.Action;
import com.staff.controller.Dao.AllDao;
import com.staff.controller.Dto.ProjectDto;
import com.staff.controller.Dto.noticeDto;

public class Pj_History_UpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		String url = "side_bar/pj_History_UpdateForm.jsp";
		//다오생성
		AllDao dao = AllDao.getInstance();	
		//prono 받아오기
		int prono = Integer.parseInt(request.getParameter("prono"));
		//프로 디테일부분 재활용 // dto생성
		ProjectDto dto = dao.proDetailSelectList(prono);
		
		request.setAttribute("ProDto", dto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
