package com.staff.controller.Dto;

public class LicenseDto {
	/*EMPNO	VARCHAR2(10)			사원번호입니다.
	LICNO	VARCHAR2(30)			자격증번호입니다. (고유번호있음)
	LIC_NM	VARCHAR2(100)			자격증 이름입니다.
	LICORG	VARCHAR2(200)			각 자격증의 발행처입니다.
	LIC_DT	DATE			취득일입니다.
	LIC_END_DT	DATE			만료일자입니다.*/
	
	private String	empno;
	private String	licno;
	private String	lic_nm;
	private String	licorg;
	private String	lic_dt;
	private String	lic_end_dt;
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getLicno() {
		return licno;
	}
	public void setLicno(String licno) {
		this.licno = licno;
	}
	public String getLic_nm() {
		return lic_nm;
	}
	public void setLic_nm(String lic_nm) {
		this.lic_nm = lic_nm;
	}
	public String getLicorg() {
		return licorg;
	}
	public void setLicorg(String licorg) {
		this.licorg = licorg;
	}
	public String getLic_dt() {
		return lic_dt;
	}
	public void setLic_dt(String lic_dt) {
		this.lic_dt = lic_dt;
	}
	public String getLic_end_dt() {
		return lic_end_dt;
	}
	public void setLic_end_dt(String lic_end_dt) {
		this.lic_end_dt = lic_end_dt;
	}
	@Override
	public String toString() {
		return "LicenseDto [empno=" + empno + ", licno=" + licno + ", lic_nm=" + lic_nm + ", licorg=" + licorg
				+ ", lic_dt=" + lic_dt + ", lic_end_dt=" + lic_end_dt + ", toString()=" + super.toString() + "]";
	}
	
	
}
