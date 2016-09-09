package com.staff.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.staff.common.Action;

@WebServlet("/allMember")
public class AllMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AllMember() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) 
					throws ServletException, IOException {
		String command = request.getParameter("command");
		
		ActionFactory af = ActionFactory.getInstance();
		Action action = af.getAction(command);
		
		if(action != null) {
			action.execute(request, response);
		
		}
		
	}

	
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		//포스트쪽 한글화 두겟으로 보내기
		
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
