package com.springboot.jpa.Util.practicalProgrammes;

import java.util.ArrayList;

public class ImmutableClassTest1 {

	public static void main(String[] args) {
	ImmutableClass immutableClass = new ImmutableClass(100, "lavanya");
	ImmutableClass immutableClass2 = new ImmutableClass(200, "Shwetha");

	
		
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		System.out.println(immutableClass.getEmpid() +" " +immutableClass.getName());
		System.out.println(immutableClass2.getEmpid() +" " +immutableClass2.getName());
		
		String str1 = new String();
		
		
		
	}
}
