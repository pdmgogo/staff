package com.staff.Action;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.staff.common.Action;
import com.staff.controller.Dao.AllDao;
import com.staff.controller.Dto.noticeDto;


public class NoticeDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		String url = "side_bar/noticeDetail.jsp";
		//디비와 연동될 dto생성
		AllDao dao = AllDao.getInstance();
		noticeDto dto = new noticeDto();
		dto.setNotno(Integer.parseInt(request.getParameter("notno")));
		

		int result = dao.noticeSelectList(dto);
		
		if(result == 1) {
			
			dao.Updatehit(dto);
			
			request.setAttribute("Dto", dto);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);		
		
	}

}
