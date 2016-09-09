package com.staff.controller.Dto;

import java.sql.Timestamp;

//공지사항 테이블
public class noticeDto {
	//공지사항번호
	private int notno;
	//사원번호
	private String empno;
	//공지사항 제목
	private String not_nm;
	//공지사항 작성일
	private Timestamp not_dt;
	//공지사항 조회수
	private int not_hits;
	//공지사항 내용
	private String notcon;
	
	//사원이름
	private String empl_nm;
	
	
	
	
	public String getEmpl_nm() {
		return empl_nm;
	}
	public void setEmpl_nm(String empl_nm) {
		this.empl_nm = empl_nm;
	}
	public int getNotno() {
		return notno;
	}
	public void setNotno(int notno) {
		this.notno = notno;
	}
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getNot_nm() {
		return not_nm;
	}
	public void setNot_nm(String not_nm) {
		this.not_nm = not_nm;
	}
	public Timestamp getNot_dt() {
		return not_dt;
	}
	public void setNot_dt(Timestamp not_dt) {
		this.not_dt = not_dt;
	}
	public int getNot_hits() {
		return not_hits;
	}
	public void setNot_hits(int not_hits) {
		this.not_hits = not_hits;
	}
	public String getNotcon() {
		return notcon;
	}
	public void setNotcon(String notcon) {
		this.notcon = notcon;
	}
	@Override
	public String toString() {
		return "noticeDto [notno=" + notno + ", empno=" + empno + ", not_nm=" + not_nm + ", not_dt=" + not_dt
				+ ", not_hits=" + not_hits + ", notcon=" + notcon + ", empl_nm=" + empl_nm + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
}
