package com.springboot.jpa.Util;

//user defined exception Class
public class EmployeenotfoundException extends RuntimeException { 

	public String message;

	public EmployeenotfoundException(String message) {
		super();
		this.message = message;
	} 
	

}
