package com.staff.Action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.staff.common.Action;
import com.staff.controller.Dao.AllDao;
import com.staff.controller.Dto.ProjectDto;

import oracle.net.aso.d;

public class Pj_History_UpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		String url = "side_bar/Pj_History_Detail.jsp";
		ProjectDto dto = new ProjectDto();
		int prono = Integer.parseInt(request.getParameter("prono"));
		
		dto.setProno(prono);
		dto.setPro_nm(request.getParameter("pro_nm"));
		dto.setProsta(request.getParameter("prosta"));
		dto.setProend(request.getParameter("proend"));
		dto.setPcontent(request.getParameter("pcontent"));
		
		AllDao dao = AllDao.getInstance();
		//cproject 테이블 업뎃
		dao.projectUpdate(dto);
		
		//수행역활 받아오기
		String rolenum = request.getParameter("rolenum");
		
		//수행역활 번호 업뎃하기
		//수행역활 가지고 오기
		// 아이디 사번 가지고 오기
		
		dao.empprojectUpdate(prono , rolenum);
		//스킬번호 지우기
		
		dao.skillDelete(prono);
		//스킬번호 다시 인설트
		String[] sknum = request.getParameterValues("sknum");
		
		
		for (int i =0; i < sknum.length; i++) {
			//체크박스에 저장된 값을 하나하나 db에 저장
			String sk = sknum[i];
			dao.proSkillUpdate(prono, sk); 
		}
		ArrayList skList = dao.proDetailSkill(prono);
		//아이디 사번 포함 셀렉
		ProjectDto prodto= dao.proDetailSelectList(prono);
		request.setAttribute("ProDetail", prodto);
		request.setAttribute("skill", skList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
