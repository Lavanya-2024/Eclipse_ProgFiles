package com.springboot.jpa.model;

import java.util.List;

public class Response2 {
	
private Object data; 
private List errors;

public Object getData() {
	return data;
}

public void setData(Object data) {
	this.data = data;
}

public List getErrors() {
	return errors;
}

public void setErrors(List errors) {
	this.errors = errors;
}



}
