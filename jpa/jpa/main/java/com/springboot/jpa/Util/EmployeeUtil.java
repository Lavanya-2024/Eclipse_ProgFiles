package com.springboot.jpa.Util;

import com.springboot.jpa.entity.EmployeeEntity;
import com.springboot.jpa.model.Employee;

public class EmployeeUtil {
	
	public static EmployeeEntity copydatafromemptoentity(Employee employee)
	{
	  EmployeeEntity employeeEntity = new EmployeeEntity();
	 
	  employeeEntity.setId(employee.getId());
	  employeeEntity.setEname(employee.getEname());
	  employeeEntity.setEadd(employee.getEadd());
	  employeeEntity.setEmob(employee.getEmob());
	  employeeEntity.setEmail(employee.getEmail());
	  
	  return employeeEntity;
	}
	public static Employee copydatafromEntitytoemp (EmployeeEntity entity)
	{
		Employee employee = new Employee();
		
		employee.setId(entity.getId());
		employee.setEname(entity.getEname());
		employee.setEmob(entity.getEmob());
		employee.setEadd(entity.getEadd());
		employee.setEmail(entity.getEmail());
		
		return employee;
		
	}
	
	

}
