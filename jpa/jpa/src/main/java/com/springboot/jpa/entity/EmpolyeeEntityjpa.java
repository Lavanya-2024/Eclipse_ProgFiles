package com.springboot.jpa.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "empolyee")
public class EmpolyeeEntityjpa {// childs
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	@Column(name = "employeeid")
	private long employeeId;
	@Column(name = "name")
	private String name;
	@Column(name = "address")
	private String address;
	@Column(name = "email")
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "empolyee_company_id", referencedColumnName = "id")
	private CompanyIdEntity companyIdEntity;//parent
	
	
	public CompanyIdEntity getCompanyIdEntity() {
		return companyIdEntity;
	}
	public void setCompanyIdEntity(CompanyIdEntity companyIdEntity) {
		this.companyIdEntity = companyIdEntity;
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
