package com.staff.Action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.staff.common.Action;

public class LoginFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		String url = "login/loginForm.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
