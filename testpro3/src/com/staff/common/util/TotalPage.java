package com.staff.common.util;

import java.awt.List;
import java.util.ArrayList;

public class TotalPage {
	

//	int totalRecord; //쿼리문 실행후 서블릿에서 받습니다.
//	int numPerPage; //한 페이지에서 보일 레코드 수
	public int TotalP(int totalRecord, int numPerPage) {
		int totalPage = 0; //총 페이지수
	
		if (totalRecord != 0) {
			if (totalRecord % numPerPage == 0) {
				totalPage = totalRecord / numPerPage;
			} else {
				totalPage = totalRecord / numPerPage + 1;
			}
			
		}
		return totalPage;
	}
	
	public int CurP(int curPage) {
		curPage = ("curPage") == null ? 1 : (curPage);
		return curPage;
	}
	public int Start(int curPage, int numPerPage) {
		int start = (curPage - 1) * numPerPage + 1;
		return start;
	}
	public int End (int start, int numPerPage) {
		int end = start + numPerPage - 1;
		return end;
	}
	
	public ArrayList Paging(int pagePerBlock,int curPage, int totalPage) {
		ArrayList Plist = new ArrayList();
//	int pagePerBlock; // 블록당 페이지수를 저장할 변수와 초기화
		int block =1;// 현재 블록 저장 변수와 초기화
	
		if(curPage % pagePerBlock == 0){
			block = curPage / pagePerBlock;
		}else{
			block = curPage / pagePerBlock + 1;
		}
		Plist.add(block);
		
		int firstPage = (block -1) * pagePerBlock +1;
		int lastPage = block * pagePerBlock;
	
		int totalBlock = 0;
	
		if(totalPage > 0){
			if(totalPage % pagePerBlock == 0){
				totalBlock = totalPage / pagePerBlock; 
			}else{
				totalBlock = totalPage / pagePerBlock + 1;
			}
		}
		Plist.add(lastPage);
		Plist.add(totalBlock);
		return Plist;
	}
}