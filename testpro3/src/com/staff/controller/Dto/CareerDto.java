package com.staff.controller.Dto;
//경력
public class CareerDto {
	/*EMPNO	VARCHAR2(10)			이걸 기반으로 정리합니다.
	COMP_NM	VARCHAR2(100)			예전회사명입니다.
	COMSTA	VARCHAR2(100)			예전에 일했던 회사입사일입니다.
	COMEND	VARCHAR2(100)			예전회사의 퇴사일입니다.
	DEPT_NM_B	VARCHAR2(30)			예전회사의 무서명입니다.
	JOB_NM_B	VARCHAR2(30)			예전회사의 직급명입니다.
	COMBUS	VARCHAR2(2000)			예전회사의 담당업무입니다.
	REASON	VARCHAR2(2000)			예전회사의 퇴사이유입니다.*/
	
	private String	empno;
	private String	comp_nm;
	private String	comsta;
	private String	comend;
	private String	dept_nm_b;
	private String	job_nm_b;
	private String	combus;
	private String	reason;
	
	
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getComp_nm() {
		return comp_nm;
	}
	public void setComp_nm(String comp_nm) {
		this.comp_nm = comp_nm;
	}
	public String getComsta() {
		return comsta;
	}
	public void setComsta(String comsta) {
		this.comsta = comsta;
	}
	public String getComend() {
		return comend;
	}
	public void setComend(String comend) {
		this.comend = comend;
	}
	public String getDept_nm_b() {
		return dept_nm_b;
	}
	public void setDept_nm_b(String dept_nm_b) {
		this.dept_nm_b = dept_nm_b;
	}
	public String getJob_nm_b() {
		return job_nm_b;
	}
	public void setJob_nm_b(String job_nm_b) {
		this.job_nm_b = job_nm_b;
	}
	public String getCombus() {
		return combus;
	}
	public void setCombus(String combus) {
		this.combus = combus;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Override
	public String toString() {
		return "CareerDto [empno=" + empno + ", comp_nm=" + comp_nm + ", comsta=" + comsta + ", comend=" + comend
				+ ", dept_nm_b=" + dept_nm_b + ", job_nm_b=" + job_nm_b + ", combus=" + combus + ", reason=" + reason
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
