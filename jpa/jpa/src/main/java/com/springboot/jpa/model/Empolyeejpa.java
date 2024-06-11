package com.springboot.jpa.model;

public class Empolyeejpa {// childs
	private long employeeId;
	private String name;
	private String address;
	private String email;

	private CompanyId companyId;// parent

	public CompanyId getCompanyId() {
		return companyId;
	}

	public void setCompanyId(CompanyId companyId) {
		this.companyId = companyId;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
