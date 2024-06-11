package com.springboot.jpa.Util.practicalProgrammes;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationEx1 {
	
	public static void main(String[] args) throws IOException {
		Serialization_Employee emp = new Serialization_Employee(001,"Lavanya");
		
// Serialization 
    String file ="C:\\Users\\LavanyaGC\\Downloads\\files\\inputfileSerialization";
	FileOutputStream fop = new FileOutputStream(file);
	ObjectOutputStream obs = new ObjectOutputStream(fop);
	
	obs.writeObject(emp);
	obs.close();
	fop.close();
	System.out.println("successfully serialized");
		
	}
	
	

}
