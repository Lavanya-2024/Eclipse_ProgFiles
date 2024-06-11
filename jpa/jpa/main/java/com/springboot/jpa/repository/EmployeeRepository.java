package com.springboot.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.jpa.entity.EmployeeEntity;

import jakarta.transaction.Transactional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer>{

	public EmployeeEntity findByEmail(String email);
	
	public List<EmployeeEntity> findEmpByEnameAndEadd(String name, String address);
	
	  @Modifying
	  @Transactional
	  //@Query("delete from EmployeeEntity ee where ee.email= : email")
	  @Query(value= "delete from employeedetails where email=:email",nativeQuery = true)  
	  public Integer deleteByEmail(@Param("email") String email);
	  
	  @Query("select ee from EmployeeEntity ee where ee.id = :id") // used Named Parameter
		public EmployeeEntity getEmployeeById(@Param("id") int id);
	
	
}
