package com.springboot.jpa.onetomany;

import java.util.HashSet;
import java.util.Set;

public class User {
	private long id;
	private String fname;
	private String lname;
	private int age;
	private String email;
	private String address;

	private Set<CardDetails> cardDetails ;
	

	

	public Set<CardDetails> getCardDetails() {
		return cardDetails;
	}

	public void setCardDetails(Set<CardDetails> cardDetails) {
		this.cardDetails = cardDetails;
	}

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

}
