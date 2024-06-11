package com.springboot.jpa.Util;

import com.springboot.jpa.entity.CompanyIdEntity;
import com.springboot.jpa.entity.EmpolyeeEntityjpa;
import com.springboot.jpa.model.CompanyId;
import com.springboot.jpa.model.Empolyeejpa;

public class CompanyIdUtil {
	
	public static CompanyId copyDataFromEntityToModel(CompanyIdEntity CompanyIdEntity) {
		CompanyId companyId =new CompanyId();
		companyId.setCompanyBranch(CompanyIdEntity.getCompanyBranch());
		companyId.setCompanyid(CompanyIdEntity.getCompanyid());
		companyId.setCompanyLocation(CompanyIdEntity.getCompanyLocation());
		
		EmpolyeeEntityjpa empolyeeEntity=	CompanyIdEntity.getEmpolyeeEntity();
		
		Empolyeejpa empolyee =new Empolyeejpa();
		empolyee.setAddress(empolyeeEntity.getAddress());
		empolyee.setEmail(empolyeeEntity.getEmail());
		empolyee.setEmployeeId(empolyeeEntity.getEmployeeId());
		empolyee.setName(empolyeeEntity.getName());
		empolyee.setCompanyId(companyId);
		companyId.setEmpolyee(empolyee);
		return companyId;
		
	}
	
	public static CompanyIdEntity copyDataFromModelToEntity(CompanyId CompanyId) {
		CompanyIdEntity companyIdEntity =new CompanyIdEntity();
		
		companyIdEntity.setCompanyBranch(CompanyId.getCompanyBranch());
		companyIdEntity.setCompanyid(CompanyId.getCompanyid());
		companyIdEntity.setCompanyLocation(CompanyId.getCompanyLocation());
		// IT GIVES EMPLOYEE OBJECT TOO , SO iT HAS TO STORE IN employee-object 
		Empolyeejpa empolyee=	CompanyId.getEmpolyee();
		
		// the above employee Object will have to store in EmployeeEntity too 
		EmpolyeeEntityjpa empolyeeEntity =new EmpolyeeEntityjpa();
		
		empolyeeEntity.setAddress(empolyee.getAddress());
		empolyeeEntity.setEmail(empolyee.getEmail());
		empolyeeEntity.setEmployeeId(empolyee.getEmployeeId());
		empolyeeEntity.setName(empolyee.getName());
		
		empolyeeEntity.setCompanyIdEntity(companyIdEntity);
		
		companyIdEntity.setEmpolyeeEntity(empolyeeEntity);
		
		return companyIdEntity;
		
	}
	
	public static EmpolyeeEntityjpa copyDataFromModelToEmpolyeeEntity(Empolyeejpa empolyee) {
		EmpolyeeEntityjpa empolyeeEntity =new EmpolyeeEntityjpa();
		empolyeeEntity.setAddress(empolyee.getAddress());
		empolyeeEntity.setEmail(empolyee.getEmail());
		empolyeeEntity.setEmployeeId(empolyee.getEmployeeId());
		empolyeeEntity.setName(empolyee.getName());
		CompanyId companyId=	empolyee.getCompanyId();
		CompanyIdEntity companyIdEntity =new CompanyIdEntity();
		companyIdEntity.setCompanyBranch(companyId.getCompanyBranch());
		companyIdEntity.setCompanyid(companyId.getCompanyid());
		companyIdEntity.setCompanyLocation(companyId.getCompanyLocation());
		companyIdEntity.setEmpolyeeEntity(empolyeeEntity);
		empolyeeEntity.setCompanyIdEntity(companyIdEntity);
		return empolyeeEntity;
		
	}
	
	

}
