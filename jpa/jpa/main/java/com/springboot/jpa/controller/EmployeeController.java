package com.springboot.jpa.controller;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jpa.model.Employee;
import com.springboot.jpa.model.EmployeeResponse;
import com.springboot.jpa.model.Employees;
import com.springboot.jpa.model.Response2;
import com.springboot.jpa.service.EmployeeService;

@RestController
public class EmployeeController {
	

	@Autowired
	EmployeeService employeeService;

	String status = "fail";
  
	@PostMapping("/saveemp")
	public ResponseEntity<String> saveemp(@RequestBody Employee employee) {
		int i = employeeService.saveemp(employee);
		if (i == 1) {
			status = "success";
		}

		return new ResponseEntity<String>(status, HttpStatus.OK);
	}

	@GetMapping("/getAllempDetails")
	public ResponseEntity<EmployeeResponse> getAllempDetails() {
		return new ResponseEntity<EmployeeResponse>(employeeService.getAllempDetails(), HttpStatus.OK);

	}
	
	
// Sorting 	
	@GetMapping("/getAllempDetails/{field}")
	public EmployeeResponse getAllempDetails_sorting(@PathVariable String field ) {
		EmployeeResponse   employeeResponse = employeeService.getAllempDetails_sorting(field);
		return employeeResponse;

	}
    
// PAGINATION	
	@GetMapping("/getAllempDetails_pagination/{pageno}/{pageSize}")
	public EmployeeResponse getAllempDetails_pagination(@PathVariable int pageno, @PathVariable int pageSize) {
		EmployeeResponse   employeeResponsewithpagination = employeeService.getAllempDetails_pagination(pageno, pageSize);
	        return employeeResponsewithpagination;
	}
	

//Pagination and Sorting
	@GetMapping("/paginationAndSort/{pageno}/{pageSize}/{field}")
	    private EmployeeResponse getAllempDetails_WithPaginationAndSort(@PathVariable int pageno, @PathVariable int pageSize,@PathVariable String field) {
		EmployeeResponse   employeeResponsewithpaginationandsorting = employeeService.getAllempDetails_WithPaginationAndSort(pageno, pageSize, field);
	        return employeeResponsewithpaginationandsorting ;
	    }
	@GetMapping("/getEmpId")
	public ResponseEntity<EmployeeResponse> getEmpId(@RequestParam int id) {
		return new ResponseEntity<EmployeeResponse>(employeeService.getEmpId(id), HttpStatus.OK);
	}

	@DeleteMapping("/deletebyId/{empid}")
	public ResponseEntity<EmployeeResponse> deletebyId(@PathVariable int empid) {
		return new ResponseEntity<EmployeeResponse>(employeeService.deletebyId(empid), HttpStatus.OK);
	}

	@PostMapping("/saveAllEmployees")
	public ResponseEntity<Void> saveAllEmployees(@RequestBody Employees employees) {
		String status = employeeService.saveAllEmployees(employees);
		System.out.println(status);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping("/getEmpId2")
	public ResponseEntity<EmployeeResponse> getEmpId2(@RequestParam int id) {
		return new ResponseEntity<EmployeeResponse>(employeeService.getEmpId2(id), HttpStatus.OK);
	}

	@GetMapping("/getEmpEmail")
	public ResponseEntity<EmployeeResponse> getEmpEmail(@RequestParam String email) {
		return new ResponseEntity<EmployeeResponse>(employeeService.getEmpEmail(email), HttpStatus.OK);
	}

	@GetMapping("/getEmpByEnameAndEadd")
	public ResponseEntity<EmployeeResponse> getEmpByEnameAndEadd(@RequestParam String name,
			@RequestParam String address) {
		return new ResponseEntity<EmployeeResponse>(employeeService.getEmpByEnameAndEadd(name, address), HttpStatus.OK);
	}

	@DeleteMapping("/deleteByEmail")
	public ResponseEntity<Response2> deleteByEmail(@RequestParam String empMail) {
		return new ResponseEntity<Response2>(employeeService.deleteByEmail(empMail), HttpStatus.OK);
	}
	
	@PutMapping("/updateEmployeeDetails") // when you want to update Employee details on the basis of ID and the given data
	public ResponseEntity<EmployeeResponse>  updateEmployeeDetails(@RequestParam int id, @RequestBody Employee employee){
		return new ResponseEntity<EmployeeResponse>(employeeService.updateEmployeeDetails(id,employee), HttpStatus.OK);		
	}

}
