package com.springboot.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springboot.jpa.model.CompanyId;
import com.springboot.jpa.model.Empolyeejpa;
import com.springboot.jpa.service.CompanyService;



@RestController
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@PostMapping("/createcompayId")
	public ResponseEntity<Void> createCompayId(@RequestBody CompanyId companyId) {

		return new ResponseEntity<Void>(
				companyService.createCompayId(companyId) ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	@PostMapping("/createemployee")
	public ResponseEntity<Void> createemployee(@RequestBody Empolyeejpa empolyee) {

		return new ResponseEntity<Void>(
				companyService.createemployee(empolyee) ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	@DeleteMapping("/deletebyemail22")
	public void deletebyemail22(String email) {
		RestTemplate restTemplate = new RestTemplate();
		//restTemplate.delete("http://localhost:2050/deletebyemail?email=" + email);
		String url = "http://localhost:2050/deletebyemail?email="+email;
		restTemplate.exchange(url, HttpMethod.DELETE,null,String.class);
		System.out.println("Person Deleted successfully");
	}
	
}
