package com.staff.controller.Dto;

public class EmpDto {
	private String empno;
	private String deptno;
	private String jobno;
	private String id;
	private String pwd;
	private String empl_nm;
	private String fjumin;
	private String bjumin;
	private String hiredate;
	private String resigndate;
	private String email;
	private String zip_cd;
	private String addr;
	private String deaddr;
	private int sal;
	private String etc;
	private String eregdate;
	private String epic;
	private String admin;
	// int 순번
	private int nono;
	
	private String dept_nm;
	private String job_nm;

	public String getDept_nm() {
		return dept_nm;
	}

	public void setDept_nm(String dept_nm) {
		this.dept_nm = dept_nm;
	}

	public String getJob_nm() {
		return job_nm;
	}

	public void setJob_nm(String job_nm) {
		this.job_nm = job_nm;
	}

	public int getNono() {
		return nono;
	}

	public void setNono(int nono) {
		this.nono = nono;
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getDeptno() {
		return deptno;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}

	public String getJobno() {
		return jobno;
	}

	public void setJobno(String jobno) {
		this.jobno = jobno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmpl_nm() {
		return empl_nm;
	}

	public void setEmpl_nm(String empl_nm) {
		this.empl_nm = empl_nm;
	}

	public String getFjumin() {
		return fjumin;
	}

	public void setFjumin(String fjumin) {
		this.fjumin = fjumin;
	}

	public String getBjumin() {
		return bjumin;
	}

	public void setBjumin(String bjumin) {
		this.bjumin = bjumin;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public String getResigndate() {
		return resigndate;
	}

	public void setResigndate(String resigndate) {
		this.resigndate = resigndate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getZip_cd() {
		return zip_cd;
	}

	public void setZip_cd(String zip_cd) {
		this.zip_cd = zip_cd;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getDeaddr() {
		return deaddr;
	}

	public void setDeaddr(String deaddr) {
		this.deaddr = deaddr;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

	public String getEregdate() {
		return eregdate;
	}

	public void setEregdate(String eregdate) {
		this.eregdate = eregdate;
	}

	public String getEpic() {
		return epic;
	}

	public void setEpic(String epic) {
		this.epic = epic;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public EmpDto() {

	}

	@Override
	public String toString() {
		return "EmpDto [empno=" + empno + ", deptno=" + deptno + ", jobno=" + jobno + ", id=" + id + ", pwd=" + pwd
				+ ", empl_nm=" + empl_nm + ", fjumin=" + fjumin + ", bjumin=" + bjumin + ", hiredate=" + hiredate
				+ ", resigndate=" + resigndate + ", email=" + email + ", zip_cd=" + zip_cd + ", addr=" + addr
				+ ", deaddr=" + deaddr + ", sal=" + sal + ", etc=" + etc + ", eregdate=" + eregdate + ", epic=" + epic
				+ ", admin=" + admin + ", nono=" + nono + ", dept_nm=" + dept_nm + ", job_nm=" + job_nm
				+ ", toString()=" + super.toString() + "]";
	}

	
}

	