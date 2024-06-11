package com.springboot.jpa.model;

import java.util.List;

public class Employees {

  private List<Employee> employeeslist;

public List<Employee> getEmployeeslist() {
	return employeeslist;
}

public void setEmployeeslist(List<Employee> employeeslist) {
	this.employeeslist = employeeslist;
}
  
}
