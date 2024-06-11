package com.springboot.jpa.Consumer;

public class ResponseModel1 {
	
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ResponseModel1 [status=" + status + "]";
	}

}
