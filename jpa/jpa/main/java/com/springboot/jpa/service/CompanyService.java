package com.springboot.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.jpa.Util.CompanyIdUtil;
import com.springboot.jpa.entity.CompanyIdEntity;
import com.springboot.jpa.entity.EmpolyeeEntityjpa;
import com.springboot.jpa.model.CompanyId;
import com.springboot.jpa.model.Empolyeejpa;
import com.springboot.jpa.repository.CompanyIdRepository;
import com.springboot.jpa.repository.EmployeeRepository;
import com.springboot.jpa.repository.EmployeeRepositoryjpa;

@Service
public class CompanyService {
	@Autowired
	CompanyIdRepository companyIdRepository;
	@Autowired
	EmployeeRepositoryjpa employeeRepositoryjpa;

	public boolean createCompayId(CompanyId companyId) {
	
		CompanyIdEntity companyIdEntity = CompanyIdUtil.copyDataFromModelToEntity(companyId);
		return companyIdRepository.save(companyIdEntity) == null ? false : true;
	}

	public boolean createemployee(Empolyeejpa empolyee) {
	
		EmpolyeeEntityjpa empolyeeEntity=	CompanyIdUtil.copyDataFromModelToEmpolyeeEntity(empolyee);
		return employeeRepositoryjpa.save(empolyeeEntity)== null ? false : true;
	}

}
