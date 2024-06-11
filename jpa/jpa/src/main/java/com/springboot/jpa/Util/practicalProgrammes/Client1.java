package com.springboot.jpa.Util.practicalProgrammes;
import java.util.ArrayList;
import java.util.List;

public class Client1 {

	public static void main(String[] args) {
		
		List<String> hobbies = new ArrayList();
		hobbies.add("Music");
		hobbies.add("Tv");
		
		ImmutableClass obj = new ImmutableClass(1001, "Lasya", hobbies);
		
		System.out.println(obj.getHubbies());
		
		
	}
	
	
	

	
	
	
	
}
