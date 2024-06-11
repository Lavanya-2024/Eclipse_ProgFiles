package com.springboot.jpa.Util.practicalProgrammes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerializationEx {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		try {
		String file ="C:\\ACCOUNTS - MemkoIndia\\Java\\file.txt";
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream inp = new ObjectInputStream(fis);
		Serialization_Employee emp = (Serialization_Employee) inp.readObject();
		inp.close();
		fis.close();
		System.out.println("Successfully DeSerialized");
		System.out.println(emp);
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		
	}

}
