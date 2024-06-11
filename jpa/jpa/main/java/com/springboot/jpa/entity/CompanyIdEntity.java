package com.springboot.jpa.entity;

import com.springboot.jpa.model.Empolyeejpa;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "companyid")
public class CompanyIdEntity {// parent
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	@Column(name = "id")
	private long companyid;
	@Column(name = "companybranch")
	private String companyBranch;
	
	
	@Column(name = "companylocation")
	private String companyLocation;
	
	@OneToOne(mappedBy = "companyIdEntity",orphanRemoval = true,
		    cascade = CascadeType.ALL)
	
	private EmpolyeeEntityjpa empolyeeEntity;// child
	
	
	public long getCompanyid() {
		return companyid;
	}
	
	public EmpolyeeEntityjpa getEmpolyeeEntity() {
		return empolyeeEntity;
	}

	public void setEmpolyeeEntity(EmpolyeeEntityjpa empolyeeEntity) {
		this.empolyeeEntity = empolyeeEntity;
	}

	public void setCompanyid(long companyid) {
		this.companyid = companyid;
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
