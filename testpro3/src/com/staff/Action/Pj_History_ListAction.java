package com.staff.Action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.staff.common.Action;
import com.staff.controller.Dao.PageDao;
import com.staff.controller.Dto.PageDto;

public class Pj_History_ListAction implements Action {

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		
		String url = "side_bar/pj_History_List.jsp";
		
		//페이징처리
		PageDao dao = PageDao.getInstance();
		String pageNum = request.getParameter("pageNum");//페이지 번호
    	if (pageNum == null) {
    		pageNum = "1";
        } 
   
    	
    	int totalRecord = dao.proPage();
    	PageDto dto = new PageDto();
		int numPerPage = 5;
		int curPage = Integer.parseInt(pageNum);
		int pagePerBlock = 3;
		dto.setCurPage(curPage);
		dto.setTotalRecord(totalRecord);
		dto.setPagePerBlock(pagePerBlock);
		dto.setNumPerPage(numPerPage);
		dto.setTotalPage();
		dto.setBlock();
		dto.setStart();
		dto.setEnd();
		dto.setFirstPage();
		dto.setLastPage();
		dto.setTotalBlock();
		dto.setPrevPage();
		dto.setNextPage();
		ArrayList proL = dao.proList(dto.getStart(),dto.getEnd());
	
		request.setAttribute("Dto", dto);
	
		request.setAttribute("ProL", proL);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
