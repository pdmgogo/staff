package com.staff.Action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.staff.common.Action;
import com.staff.controller.Dao.AllDao;
import com.staff.controller.Dto.noticeDto;

public class NoticeUpdate implements Action {

	@Override
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		String url = "side_bar/noticeDetail.jsp";
		
		AllDao dao = AllDao.getInstance();
		noticeDto dto = new noticeDto();
		
		dto.setNotcon(request.getParameter("notcon"));
		dto.setNot_nm(request.getParameter("not_nm"));
		dto.setNotno(Integer.parseInt(request.getParameter("notno")));
		dao.noticeUpdate(dto);
		dao.noticeSelectList(dto);
		request.setAttribute("Dto", dto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
