package com.staff.Action;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.staff.common.Action;
import com.staff.controller.Dao.AllDao;
import com.staff.controller.Dto.ProjectDto;
import com.staff.controller.Dto.SkillDto;

public class Pj_History_DetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		String url = "side_bar/Pj_History_Detail.jsp";
		//디테일페이지 보일시 가지고 오는 값(프로젝트 선택 넘버)
		int prono = Integer.parseInt(request.getParameter("prono"));
		
		//다오 생성
		AllDao dao = AllDao.getInstance();
		//프로젝트 dto 생성
		ProjectDto prodto = dao.proDetailSelectList(prono);
	
		int skProno = prono;
		
		ArrayList skdto = dao.proDetailSkill(skProno);
		
		request.setAttribute("ProDetail", prodto);
		request.setAttribute("skill", skdto);
		//스킬리스트
		//set prodto
		//set set skilllist
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
