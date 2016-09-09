package com.staff.controller.Dto;

import java.sql.Timestamp;
import java.util.Arrays;

public class ProjectDto {
	/*PRONO	NUMBER			회사프로젝트 번호입니다.
	PRO_NM	VARCHAR2(255)			회사프로젝트 이름입니다.
	PROSTA	VARCHAR2(100)			회사프로젝트 시작일입니다.
	Proend	VARCHAR2(100)		회사프로젝트 종료일입니다.
	PREGDATE	date		각 프로젝트의 등록일입니다.
	PCONTENT	VARCHAR2(1000)			각 프로젝트의 상세내용입니다.*/
	private int 		prono;
	private String 		pro_nm;
	private String 		prosta;
	private String 		proend;
	private Timestamp 	pregdate;
	private String 		pcontent;
	//프로젝트 아이디
	private String 		id;
	//수행역활번호
	private String  	rolenum;
	//수행역활명
	private String 		role;
	//사번
	private String		empno;
	
	

	
	
	
	
	
	
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getRolenum() {
		return rolenum;
	}
	public void setRolenum(String rolenum) {
		this.rolenum = rolenum;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getProno() {
		return prono;
	}
	public void setProno(int prono) {
		this.prono = prono;
	}
	public String getPro_nm() {
		return pro_nm;
	}
	public void setPro_nm(String pro_nm) {
		this.pro_nm = pro_nm;
	}
	public String getProsta() {
		return prosta;
	}
	public void setProsta(String prosta) {
		this.prosta = prosta;
	}
	public String getProend() {
		return proend;
	}
	public void setProend(String proend) {
		this.proend = proend;
	}
	public Timestamp getPregdate() {
		return pregdate;
	}
	public void setPregdate(Timestamp pregdate) {
		this.pregdate = pregdate;
	}
	public String getPcontent() {
		return pcontent;
	}
	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	

	}
	@Override
	public String toString() {
		return "ProjectDto [prono=" + prono + ", pro_nm=" + pro_nm + ", prosta=" + prosta + ", proend=" + proend
				+ ", pregdate=" + pregdate + ", pcontent=" + pcontent + ", id=" + id + ", rolenum=" + rolenum
				+ ", role=" + role + ", empno=" + empno + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
	
	
	
	
}
