package com.staff.Action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.staff.common.Action;
import com.staff.controller.Dao.AllDao;
import com.staff.controller.Dto.noticeDto;

public class NoticeUpdateForm implements Action {

	@Override
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		String url = "side_bar/noticeUpdate.jsp";
		//디비와 연동될 dto생성
		AllDao dao = AllDao.getInstance();
		noticeDto dto = new noticeDto();
		dto.setNotno(Integer.parseInt(request.getParameter("notno")));
		System.out.println("가지고 오나" + dto);
		int result = dao.noticeSelectList(dto);
		
		System.out.println("멀까" +result);
		if(result == 1) {
			
			request.setAttribute("Dto", dto);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);	

	}

}
