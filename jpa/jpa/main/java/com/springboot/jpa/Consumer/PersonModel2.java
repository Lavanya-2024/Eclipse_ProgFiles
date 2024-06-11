package com.springboot.jpa.Consumer;

public class PersonModel2 {

	private long id;
	private String fname;
	private String lname;
	private int age;
	private String email;
	private String address;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "PersonModel2 [id=" + id + ", fname=" + fname + ", lname=" + lname + ", age=" + age + ", email=" + email
				+ ", address=" + address + "]";
	}
	
	
}
