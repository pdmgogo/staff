package com.staff.controller.Dto;

public class PageDto {
	public PageDto() {

	}
	//스타트 페이지
	private int start;
	//엔드 페이지
	private int end;
	//블럭의 페이지 넘버
	private int curPage;//필요한 필수요건
	//총 페이지 수
	private int totalPage;
	//총 레코드 (글)수
	private int totalRecord;//DB에서 입력된 글수
	//하나의 블록당 저장할 수
	private int pagePerBlock;//개발자가 지정
	//블럭넘버
	private int block;
	//처음 블럭페이지
	private int firstPage;
	//마지막 블럭페이지
	private int lastPage;
	//총 블럭수
	private int totalBlock;
	//넘버 페이지
	private int numPerPage;//개발자가 지정
	//이전 페이지
	private int prevPage;
	//다음 페이지
	private int nextPage;
	
	
	
	
	
	
	public int getPrevPage() {
		return prevPage;
	}
	
	public void setPrevPage() {
		if(this.block > 1){
			this.prevPage = this.firstPage - 1;
		}
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage() {
		if(this.block < this.totalBlock){
			this.nextPage = this.lastPage + 1;
		}
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	public int getStart() {
		return start;
	}

	public void setStart() {
		this.start = (this.curPage - 1) * this.numPerPage + 1;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd() {
		this.end = this.start + numPerPage - 1;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
			this.curPage = curPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage() {
		if (totalRecord != 0) {
			if (totalRecord % numPerPage == 0) {
				totalPage = totalRecord / numPerPage;
			} else {
				totalPage = totalRecord / numPerPage + 1;
			}
		}
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getPagePerBlock() {
		return pagePerBlock;
	}

	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}

	public int getBlock() {
		return block;
	}

	public void setBlock() {
		if(this.curPage % pagePerBlock == 0){
			this.block = this.curPage / pagePerBlock;
		}else{
			this.block = this.curPage / pagePerBlock + 1;
		}
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage() {
		this.firstPage = (this.block -1) * this.pagePerBlock +1;
	
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage() {
		this.lastPage = this.block * this.pagePerBlock;
	
	}

	public int getTotalBlock() {
		return totalBlock;
	}

	public void setTotalBlock() {
		if(this.totalPage > 0){
			if(this.totalPage % this.pagePerBlock == 0){
				this.totalBlock = this.totalPage / this.pagePerBlock; 
			}else{
				this.totalBlock = this.totalPage / this.pagePerBlock + 1;
			}
			if(this.block >= this.totalBlock){
				this.lastPage = this.totalPage;
			}
		}
		
	}
	@Override
	public String toString() {
		return "PageDto [start=" + start + ", end=" + end + ", curPage=" + curPage + ", totalPage=" + totalPage
				+ ", totalRecord=" + totalRecord + ", pagePerBlock=" + pagePerBlock + ", block=" + block
				+ ", firstPage=" + firstPage + ", lastPage=" + lastPage + ", totalBlock=" + totalBlock + ", numPerPage="
				+ numPerPage + ", prevPage=" + prevPage + ", nextPage=" + nextPage + ", toString()=" + super.toString()
				+ "]";
	}
	
	

	
	
}


