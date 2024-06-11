package com.springboot.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.jpa.entity.EmpolyeeEntityjpa;




@Repository
public interface EmployeeRepositoryjpa extends CrudRepository<EmpolyeeEntityjpa, Long> {
	
}
