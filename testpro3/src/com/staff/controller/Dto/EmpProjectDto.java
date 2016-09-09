package com.staff.controller.Dto;

public class EmpProjectDto {
	private String	 	empno;
	private int 		prono;
	private String 		rolenum;
	private String 		empbus;
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public int getProno() {
		return prono;
	}
	public void setProno(int prono) {
		this.prono = prono;
	}
	public String getRolenum() {
		return rolenum;
	}
	public void setRolenum(String rolenum) {
		this.rolenum = rolenum;
	}
	public String getEmpbus() {
		return empbus;
	}
	public void setEmpbus(String empbus) {
		this.empbus = empbus;
	}
	@Override
	public String toString() {
		return "EmpProjectDto [empno=" + empno + ", prono=" + prono + ", rolenum=" + rolenum + ", empbus=" + empbus
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
