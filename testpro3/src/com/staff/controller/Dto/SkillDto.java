package com.staff.controller.Dto;
//스킬 dto
public class SkillDto {
	private String sknum;
	private String skill_nm;
	
	
	public String getSknum() {
		return sknum;
	}
	public void setSknum(String sknum) {
		this.sknum = sknum;
	}
	public String getSkill_nm() {
		return skill_nm;
	}
	public void setSkill_nm(String skill_nm) {
		this.skill_nm = skill_nm;
	}
	@Override
	public String toString() {
		return "SkillDto [sknum=" + sknum + ", skill_nm=" + skill_nm + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}
