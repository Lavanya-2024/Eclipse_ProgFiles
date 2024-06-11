package com.springboot.jpa.Util.practicalProgrammes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialization123 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Serialization_Employee emp = new Serialization_Employee(1000, "lavanya");
		
		//String filepath = "C:\\\\Users\\\\LavanyaGC\\\\Downloads\\\\files\\\\inputfileSerialization2";
		
		File file = new File("C:\\\\Users\\\\LavanyaGC\\\\Downloads\\\\files\\\\inputfileSerialization2");
		FileOutputStream fop = new FileOutputStream(file);
		ObjectOutputStream obs = new ObjectOutputStream(fop);
		
		obs.writeObject(emp);
		obs.close();
		fop.close();
		System.out.println("serialized successfully");
		
	
	
	File file2 = new File("C:\\\\Users\\\\LavanyaGC\\\\Downloads\\\\files\\\\inputfileSerialization2");
	FileInputStream fip = new FileInputStream(file2);
	ObjectInputStream obi = new ObjectInputStream(fip);
	Serialization_Employee emp2= (Serialization_Employee) obi.readObject();
	obi.close();
	fip.close();
	System.out.println("De-serialized successfully");
	System.out.println("emp id---"+ emp2.id);
	System.out.println("emp id---"+ emp2.name);
	}	
}
