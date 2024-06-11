package com.springboot.jpa.entity;

import com.springboot.jpa.model.Order;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "amazonuser")
public class AmazonUserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "userid")
	private long userId;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "mob")
	private String mob;
	
	@Column(name = "add1city")
	private String add1City;
	

	@Column(name = "add2state")
	private String add2State;
	
	@OneToOne(mappedBy = "amazonUserEntity", orphanRemoval = true, cascade = CascadeType.ALL)
	private OrderEntity orderEntity;
	
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


	public OrderEntity getOrderEntity() {
		return orderEntity;
	}


	public void setOrderEntity(OrderEntity orderEntity) {
		this.orderEntity = orderEntity;
	}


	
	
	
}
