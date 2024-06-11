package com.springboot.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jpa.model.AmazonUser;
import com.springboot.jpa.model.CompanyId;
import com.springboot.jpa.model.Order;
import com.springboot.jpa.service.AmazonUserandAddService;

@RestController
public class AmazonUserandAddressController {
	
	@Autowired
	AmazonUserandAddService amazonUserandAddService;
	
	@PostMapping("/creatorder")
	public  ResponseEntity<Void> creatorder(@RequestBody Order order)
	{
					
		return new ResponseEntity<Void>(amazonUserandAddService.creatorder(order)? HttpStatus.CREATED:HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("/creatuser")
	public ResponseEntity<Void> creatuser(@RequestBody AmazonUser amazonUser)
	{
	  return new ResponseEntity<Void>( amazonUserandAddService.creatuser(amazonUser)? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	}
