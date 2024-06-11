package com.springboot.jpa.model;

import java.util.Date;

public class Order {

	private long orderId;
	private String orderItem;
	private String OrderDate;
	private String deliveryDate;
	// userId (Foreign Key)

	private AmazonUser amazonUser;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(String orderItem) {
		this.orderItem = orderItem;
	}

	public String getOrderDate() {
		return OrderDate;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}

	public AmazonUser getAmazonUser() {
		return amazonUser;
	}

	public void setAmazonUser(AmazonUser amazonUser) {
		this.amazonUser = amazonUser;
	}

}
//AmazonUser(Parent) and Order(Child) 
