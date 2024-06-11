package com.springboot.jpa.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.springboot.jpa.model.Employee;
import com.springboot.jpa.model.Register;
import com.springboot.jpa.service.RegisterService;

@RestController
public class RegistrationController {
	
	@Autowired
	RegisterService registerService;
	
	
	@PostMapping("/register")
	public ResponseEntity<String> saveemp(@RequestBody Register register) throws IllegalAccessException, InvocationTargetException {
		int i = registerService.saveuser(register);
		 String status = "fail";
		if (i == 1) {
			status = "success";
		}

		return new ResponseEntity<String>(status, HttpStatus.OK);
	}

	
	@GetMapping("/login")
	public ResponseEntity<HashMap<String, Object>> login(@RequestParam String email , @RequestParam String pwd) throws Exception {
		return new ResponseEntity<HashMap<String, Object>>(registerService.login(email,pwd), HttpStatus.OK);
	}
	
	@GetMapping("/getuserbyheadertoken")
	public ResponseEntity<Register> getuserbyheadertoken(@RequestHeader("Authorization") String token) throws Exception {
		
		
		
		return new ResponseEntity<Register>(registerService.getuserbyheadertoken(token), HttpStatus.OK);
		
	}
	
	
	
}
