package com.staff.controller.Dto;

public class AddressDto {
	private String	Addrno; 	
	private String  zip_cd;	
	private String  sido;			
	private String  sigungu;		
	private String  dong;		
	private String  ri;		
	private String  bldg; 	
	private String  bungi;
	public String getAddrno() {
		return Addrno;
	}
	public void setAddrno(String addrno) {
		Addrno = addrno;
	}
	public String getZip_cd() {
		return zip_cd;
	}
	public void setZip_cd(String zip_cd) {
		this.zip_cd = zip_cd;
	}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getSigungu() {
		return sigungu;
	}
	public void setSigungu(String sigungu) {
		this.sigungu = sigungu;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getRi() {
		return ri;
	}
	public void setRi(String ri) {
		this.ri = ri;
	}
	public String getBldg() {
		return bldg;
	}
	public void setBldg(String bldg) {
		this.bldg = bldg;
	}
	public String getBungi() {
		return bungi;
	}
	public void setBungi(String bungi) {
		this.bungi = bungi;
	}
	@Override
	public String toString() {
		return "AddressDto [Addrno=" + Addrno + ", zip_cd=" + zip_cd + ", sido=" + sido + ", sigungu=" + sigungu
				+ ", dong=" + dong + ", ri=" + ri + ", bldg=" + bldg + ", bungi=" + bungi + ", toString()="
				+ super.toString() + "]";
	}	
	
}
