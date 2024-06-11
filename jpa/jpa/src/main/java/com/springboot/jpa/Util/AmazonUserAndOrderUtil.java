package com.springboot.jpa.Util;

import com.springboot.jpa.entity.AmazonUserEntity;
import com.springboot.jpa.entity.OrderEntity;
import com.springboot.jpa.model.AmazonUser;
import com.springboot.jpa.model.Order;

public class AmazonUserAndOrderUtil {
	
	public AmazonUserEntity copydatafromModelToEntity(AmazonUser amazonUser)
	{
		AmazonUserEntity amazonUserEntity = new AmazonUserEntity();
		
		amazonUserEntity.setUserId(amazonUser.getUserId());
		amazonUserEntity.setUserName(amazonUser.getUserName());
		amazonUserEntity.setMob(amazonUser.getMob());
		amazonUserEntity.setAdd1City(amazonUser.getAdd1City());
		amazonUserEntity.setAdd2State(amazonUser.getAdd2State());
		
		Order order = amazonUser.getOrder();
		
		OrderEntity orderEntity = new OrderEntity();
				
		orderEntity.setOrderId(order.getOrderId());
		orderEntity.setOrderDate(order.getOrderDate());
		orderEntity.setOrderItem(order.getOrderItem());
		orderEntity.setDeliveryDate(order.getDeliveryDate());
		orderEntity.setAmazonUserEntity(amazonUserEntity);
		
		amazonUserEntity.setOrderEntity(orderEntity);
		
		return amazonUserEntity;
		
	}
	
	public OrderEntity copydatafromModelToEntity(Order order)
	{ 
		OrderEntity orderEntity = new OrderEntity();
		
		orderEntity.setOrderId(order.getOrderId());
		orderEntity.setOrderDate(order.getOrderDate());
		orderEntity.setOrderItem(order.getOrderItem());
		orderEntity.setDeliveryDate(order.getDeliveryDate());
		
		AmazonUser amazonUser = order.getAmazonUser();
		AmazonUserEntity amazonUserEntity = new AmazonUserEntity();
		
		amazonUserEntity.setUserId(amazonUser.getUserId());
		amazonUserEntity.setUserName(amazonUser.getUserName());
		amazonUserEntity.setMob(amazonUser.getMob());
		amazonUserEntity.setAdd1City(amazonUser.getAdd1City());
		amazonUserEntity.setAdd2State(amazonUser.getAdd2State());
		
		amazonUserEntity.setOrderEntity(orderEntity);
		orderEntity.setAmazonUserEntity(amazonUserEntity);
		return orderEntity;
	}

}
