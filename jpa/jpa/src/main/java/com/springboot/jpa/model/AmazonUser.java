package com.springboot.jpa.model;

public class AmazonUser {
	
	private long userId;
	private String userName;
	private String mob;
	private String add1City;
	private String add2State;
	
	private Order order ;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	public String getAdd1City() {
		return add1City;
	}

	public void setAdd1City(String add1City) {
		this.add1City = add1City;
	}

	public String getAdd2State() {
		return add2State;
	}

	public void setAdd2State(String add2State) {
		this.add2State = add2State;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	} 
	

}
