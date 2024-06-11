package com.springboot.jpa.Consumer;

import java.util.List;

public class ResponseModel2 {

	private List<PersonModel2> data;
	private String status;
	
	public List<PersonModel2> getData() {
		return data;
	}
	public void setData(List<PersonModel2> data) {
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
}
