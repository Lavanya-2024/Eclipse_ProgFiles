package com.springboot.jpa.Util.practicalProgrammes;

import java.io.Serializable;

public class Serialization_Employee implements Serializable{
	
		int id;
		transient String name;
		

		public Serialization_Employee(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + "]";
		}
			

	}


