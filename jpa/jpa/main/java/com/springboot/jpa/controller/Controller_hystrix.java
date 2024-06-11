package com.springboot.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
//@EnableHystrix

//@EnableHystrixDashboard
public class Controller_hystrix {
	
	@Autowired
	private RestTemplate template;

	@HystrixCommand(groupKey = "java techie", commandKey = "java techie", fallbackMethod = "bookMyShowFallBack")
	@GetMapping("/getpersondetails")
	public String bookShow() {
		String emailServiceResponse = template.getForObject("http://localhost:8181/emailService/send", String.class);
		String paymentServiceResponse = template.getForObject("http://localhost:8282/paymentService/pay", String.class);
		return emailServiceResponse + "\n" + paymentServiceResponse;
	} 

	@GetMapping("/bookNowWitoutHystrix")
	public String bookShowWitoutHystrix() {
		String emailServiceResponse = template.getForObject("http://localhost:8181/emailService/send", String.class);
		String paymentServiceResponse = template.getForObject("http://localhost:8282/paymentService/pay", String.class);
		return emailServiceResponse + "\n" + paymentServiceResponse;
	}

	
	public String bookMyShowFallBack() {
		return "service gateway failed...";
	}

	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}

}
