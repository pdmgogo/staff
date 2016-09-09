package com.staff.controller.Dto;

public class AchievementDto {
	/*EMPNO	VARCHAR2(10)			사원번호입니다.
	SCH_NM	VARCHAR2(300)			각 사원의 학교이름입니다.
	GRADU	CHAR(1)			졸업여부입니다.(최종)
	ADM_DT	DATE			입학일입니다.
	GRA_DT	DATE			졸업일입니다.
	MAJOR	VARCHAR2(300)			전공입니다.
	LOC	VARCHAR2(500)			소재지(주소)입니다.*/
	
	private String  empno;
	private String	sch_nm;
	private int		gradu;
	private String	adm_dt;
	private String	gra_dt;
	private String	major;
	private String	loc;
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getSch_nm() {
		return sch_nm;
	}
	public void setSch_nm(String sch_nm) {
		this.sch_nm = sch_nm;
	}
	public int getGradu() {
		return gradu;
	}
	public void setGradu(int gradu) {
		this.gradu = gradu;
	}
	public String getAdm_dt() {
		return adm_dt;
	}
	public void setAdm_dt(String adm_dt) {
		this.adm_dt = adm_dt;
	}
	public String getGra_dt() {
		return gra_dt;
	}
	public void setGra_dt(String gra_dt) {
		this.gra_dt = gra_dt;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	@Override
	public String toString() {
		return "AchievementDto [empno=" + empno + ", sch_nm=" + sch_nm + ", gradu=" + gradu + ", adm_dt=" + adm_dt
				+ ", gra_dt=" + gra_dt + ", major=" + major + ", loc=" + loc + ", toString()=" + super.toString() + "]";
	}
	
	
}
