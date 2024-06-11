package com.springboot.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.jpa.Util.AmazonUserAndOrderUtil;
import com.springboot.jpa.entity.AmazonUserEntity;
import com.springboot.jpa.entity.OrderEntity;
import com.springboot.jpa.model.AmazonUser;
import com.springboot.jpa.model.Order;
import com.springboot.jpa.model.Response2;
import com.springboot.jpa.repository.AmazonUserRepository;
import com.springboot.jpa.repository.OrderEntityRepository;

@Service
public class AmazonUserandAddService {
	@Autowired
 OrderEntityRepository orderEntityRepository;

	@Autowired
	AmazonUserRepository amazonUserRepository;

	OrderEntity orderEntity = new OrderEntity();

	public boolean creatorder(Order order) {

		AmazonUserAndOrderUtil amazonUserAndOrderUtil = new AmazonUserAndOrderUtil();
		OrderEntity orderEntity = amazonUserAndOrderUtil.copydatafromModelToEntity(order);

		return orderEntityRepository.save(orderEntity) == null ? false : true;
	}

	public boolean creatuser(AmazonUser amazonUser) {
		AmazonUserAndOrderUtil amazonUserAndOrderUtil = new AmazonUserAndOrderUtil();

		AmazonUserEntity amazonUserEntity = amazonUserAndOrderUtil.copydatafromModelToEntity(amazonUser);

		return amazonUserRepository.save(amazonUserEntity) == null ? false : true;

	}

}
