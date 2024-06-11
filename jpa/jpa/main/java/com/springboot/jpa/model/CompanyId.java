package com.springboot.jpa.model;

public class CompanyId {// parent

	private long companyid;
	private String companyBranch;
	private String companyLocation;

	private Empolyeejpa empolyee;// child

	public long getCompanyid() {
		return companyid;
	}

	public void setCompanyid(long companyid) {
		this.companyid = companyid;
	}

	
	public Empolyeejpa getEmpolyee() {
		return empolyee;
	}

	public void setEmpolyee(Empolyeejpa empolyee) {
		this.empolyee = empolyee;
	}

	public String getCompanyBranch() {
		return companyBranch;
	}

	public void setCompanyBranch(String companyBranch) {
		this.companyBranch = companyBranch;
	}

	public String getCompanyLocation() {
		return companyLocation;
	}

	public void setCompanyLocation(String companyLocation) {
		this.companyLocation = companyLocation;
	}

}
