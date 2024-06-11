package com.springboot.jpa.Util.practicalProgrammes;

import java.util.HashMap;

//Hashmap

public class HashMapNewFunctions {
	public static void main(String[] args) {
		
		HashMap<String, Integer> hm = new HashMap();
		hm.put("E-001", 10000);
		hm.put("E-002", 50000);
		hm.put("E-003", 40000);
		hm.put("E-004", 30000);
		hm.put("E-005", 80000);
		
		System.out.println("Print the map"+ hm);  // Print the map
		
       hm.computeIfPresent("E-005", (key, value)-> value=value+1055);
		//Integer value2 = hm.putIfAbsent("E-005", 500);
		                 
		hm.computeIfAbsent("E-005", (key)->1000);
	    System.out.println("edited the map"+ hm);  // Print the map
	    
	    hm.forEach((key, value)->
	    {
	    	value =+ 100; 
	    	System.out.print(key + "=" + value + " ");
	    	
	    } );
	    
	    
	    
	    
	}
}