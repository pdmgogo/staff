package com.staff.Action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.staff.common.Action;



public class NoticeInsertFromAction implements Action {

	@Override
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		String url = "side_bar/noticeInsertForm.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
