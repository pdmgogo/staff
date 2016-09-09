package com.staff.Action;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.staff.common.Action;
import com.staff.common.util.TotalPage;
import com.staff.controller.Dao.AllDao;
import com.staff.controller.Dao.PageDao;
import com.staff.controller.Dto.EmpDto;
import com.staff.controller.Dto.PageDto;

import oracle.net.aso.a;
import oracle.net.aso.p;

public class Staff_History_ListViewAction implements Action {
	@Override
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
	//나중에 관리자와 일반사원 구분 해야합니다.
		//경고창 뛰우기
		String url = "side_bar/staff_History_ListView.jsp";
		//페이징 시작
		PageDao dao = PageDao.getInstance();
		//다오 SelectAll 실행(dto에 id에 따른 정보값 가지고 오기)
		//페이징시작
	    String pageNum = request.getParameter("pageNum");//페이지 번호
	    	if (pageNum == null) {
	    		pageNum = "1";
	        } 
	   
	    	
		int totalRecord = dao.StaffPage();
		PageDto dto = new PageDto();
		int numPerPage = 3;
		int curPage = Integer.parseInt(pageNum);
		System.out.println("curPage : "+curPage);
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
		ArrayList Stafflist = dao.StaffPageView(dto.getStart(),dto.getEnd());
		
		//페이징 엔드
		request.setAttribute("Dto", dto);
		
		request.setAttribute("List", Stafflist);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	

}

//TotalPage tp = new TotalPage();
//int totalPage = tp.TotalP(totalRecord,numPerPage);
//int curPage = 3;//하드코딩이 아니라 나중에 값을 받아와야함 ㅡㅡ 고민중
//TotalPage cp = new TotalPage();
//int curp = cp.CurP(curPage);
//TotalPage sp = new TotalPage();
//int startp = sp.Start(curPage,numPerPage);
//TotalPage ep = new TotalPage();
//int endp = ep.End(startp,numPerPage);
//ArrayList list = dao.StaffPageView(startp, endp);
//System.out.println(list);
//int pagePerBlock = 5;
//TotalPage paging = new TotalPage();
//
//ArrayList Plist = paging.Paging(pagePerBlock,curPage,totalPage);

