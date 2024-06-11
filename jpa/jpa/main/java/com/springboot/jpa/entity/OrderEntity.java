package com.springboot.jpa.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.springboot.jpa.model.AmazonUser;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordertable")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderId")
	private long orderId;

	@Column(name = "orderItem")
	private String orderItem;

	@Column(name = "orderDate")
	private String orderDate;

	@Column(name = "deliveryDate")
	private String deliveryDate;

	//(Foreign Key)

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_user_Id", referencedColumnName = "userId")
	private AmazonUserEntity amazonUserEntity;

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
		return orderDate;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public void setOrderDate(String orderDate2) {
		// TODO Auto-generated method stub

	}

	public AmazonUserEntity getAmazonUserEntity() {
		return amazonUserEntity;
	}

	public void setAmazonUserEntity(AmazonUserEntity amazonUserEntity) {
		this.amazonUserEntity = amazonUserEntity;
	}

}
