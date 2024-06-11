package com.springboot.jpa.Util.practicalProgrammes;
import java.util.List;

public  final  class ImmutableClass {
	
	private  final int empid ;
	private final String name;
	
   
	
	public ImmutableClass(int id ,String name) {
    this.empid = id;
    this.name = name;
		
	}
		
  	public int getEmpid() {
		return empid;
	}

	public String getName() {
		return name;
	}

	
		
	}


