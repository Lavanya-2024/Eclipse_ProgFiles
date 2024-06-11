package com.springboot.jpa.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.springboot.jpa.Util.EmployeeUtil;
import com.springboot.jpa.Util.EmployeenotfoundException;
import com.springboot.jpa.Util.InvalidEmailException;
import com.springboot.jpa.entity.EmployeeEntity;
import com.springboot.jpa.model.Employee;
import com.springboot.jpa.model.EmployeeResponse;
import com.springboot.jpa.model.Employees;
import com.springboot.jpa.model.Response2;
import com.springboot.jpa.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public int saveemp(Employee employee)

	{
		EmployeeUtil employeeUtil = new EmployeeUtil();

		EmployeeEntity entity = employeeUtil.copydatafromemptoentity(employee);

		EmployeeEntity entity2 = employeeRepository.save(entity);
		if (entity2 != null) {
			return 1;
		}
		return 0;

	}

	/*
	 * public EmployeeResponse getAllEmployeeDetails() {
	 * 
	 * List<Employee> emplist =new ArrayList<Employee>(); Iterable<EmployeeEntity>
	 * iterable= employeeRepository.findAll();//select * from person
	 * 
	 * if(iterable!=null) { Iterator<EmployeeEntity> iterator= iterable.iterator();
	 * if(iterator !=null) {
	 * 
	 * while(iterator.hasNext()) { EmployeeEntity employeeEntity= iterator.next();
	 * Employee emp= EmployeeUtil.copydatafromEntitytoemp(employeeEntity);
	 * emplist.add(emp); } } } EmployeeResponse employeeResponse =new
	 * EmployeeResponse(); employeeResponse.setData(emplist);
	 * employeeResponse.setStatus("success");
	 * 
	 * return employeeResponse; }
	 */

	public EmployeeResponse getAllempDetails() {
		List<Employee> emplist = new ArrayList<Employee>();
		Iterable<EmployeeEntity> iterable = employeeRepository.findAll();
		if (iterable != null) {
			Iterator<EmployeeEntity> iterator = iterable.iterator();
			if (iterator != null) {

				while (iterator.hasNext()) {

					EmployeeEntity employeeEntity = iterator.next();
					Employee emp = EmployeeUtil.copydatafromEntitytoemp(employeeEntity);
					emplist.add(emp);
				}
			}

		}
		EmployeeResponse employeeResponse = new EmployeeResponse();
		employeeResponse.setList(emplist);
		employeeResponse.setStatus("success");
		return employeeResponse;
	}

// SORTING 
	
	public EmployeeResponse getAllempDetails_sorting(String field) {
		List<Employee> emplist = new ArrayList<Employee>();
		Iterable<EmployeeEntity> iterable = employeeRepository.findAll(org.springframework.data.domain.Sort.by(field));
		//Iterable<EmployeeEntity> iterable2 = employeeRepository.findAll(org.springframework.data.domain.Sort.by(org.springframework.data.domain.Sort.Direction.ASC,field));
		if (iterable != null) {
			Iterator<EmployeeEntity> iterator = iterable.iterator();
			if (iterator != null) {

				while (iterator.hasNext()) {

					EmployeeEntity employeeEntity = iterator.next();
					Employee emp = EmployeeUtil.copydatafromEntitytoemp(employeeEntity);
					emplist.add(emp);
				}
			}

		}
		EmployeeResponse employeeResponse = new EmployeeResponse();
		employeeResponse.setList(emplist);
		employeeResponse.setStatus("success");
		return employeeResponse;
	}
	
//Pagination
	
	public EmployeeResponse getAllempDetails_pagination(int pageno,int pageSize){
	  //	EmployeeResponse products = repository.findAll(PageRequest.of(pageno, pageSize));
		List<Employee> emplist = new ArrayList<Employee>();
		Iterable<EmployeeEntity> iterable = employeeRepository.findAll(PageRequest.of(pageno, pageSize));
		//Iterable<EmployeeEntity> iterable2 = employeeRepository.findAll(org.springframework.data.domain.Sort.by(org.springframework.data.domain.Sort.Direction.ASC,field));
		if (iterable != null) {
			Iterator<EmployeeEntity> iterator = iterable.iterator();
			if (iterator != null) {

				while (iterator.hasNext()) {

					EmployeeEntity employeeEntity = iterator.next();
					Employee emp = EmployeeUtil.copydatafromEntitytoemp(employeeEntity);
					emplist.add(emp);
				}
			}

		}
		EmployeeResponse employeeResponse = new EmployeeResponse();
		employeeResponse.setList(emplist);
		employeeResponse.setStatus("success");
		return employeeResponse;
    }
	
// Pagination and Sorting
		public EmployeeResponse getAllempDetails_WithPaginationAndSort(@PathVariable int pageno, @PathVariable int pageSize,@PathVariable String field){
		  
			List<Employee> emplist = new ArrayList<Employee>();
			//repository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
			Iterable<EmployeeEntity> iterable = employeeRepository.findAll(PageRequest.of(pageno, pageSize).withSort(Sort.by(field)));
			if (iterable != null) {
				Iterator<EmployeeEntity> iterator = iterable.iterator();
				if (iterator != null) {

					while (iterator.hasNext()) {

						EmployeeEntity employeeEntity = iterator.next();
						Employee emp = EmployeeUtil.copydatafromEntitytoemp(employeeEntity);
						emplist.add(emp);
					}
				}

			}
			EmployeeResponse employeeResponse = new EmployeeResponse();
			employeeResponse.setList(emplist);
			employeeResponse.setStatus("success");
			return employeeResponse;
	    }
	public EmployeeResponse getEmpId(int id) {
		Employee emp = null;
		Optional<EmployeeEntity> optional = employeeRepository.findById(id);
		if (optional.isPresent()) {
			EmployeeEntity employeeEntity = optional.get();
			EmployeeUtil employeeUtil = new EmployeeUtil();
			emp = employeeUtil.copydatafromEntitytoemp(employeeEntity);

		}
		EmployeeResponse employeeResponse = new EmployeeResponse();
		employeeResponse.setData(emp);
		employeeResponse.setStatus("success");

		return employeeResponse;
	}

	public EmployeeResponse deletebyId(int empid) {
		String ispersonDeleted = "Employee Not exit with the given id";
		if (employeeRepository.existsById(empid)) {
			employeeRepository.deleteById(empid);
			ispersonDeleted = "Deleted employee";
		}
		EmployeeResponse employeeResponse = new EmployeeResponse();
		employeeResponse.setStatus("success");
		employeeResponse.setData(ispersonDeleted);

		return employeeResponse;
	}

	public String saveAllEmployees(Employees employees) {
		String isEmployeesSaved = "Fail";
		List<Employee> emplist = employees.getEmployeeslist();
		EmployeeUtil employeeUtil = new EmployeeUtil();
		if (emplist != null && emplist.size() > 0) {
			List<EmployeeEntity> employeeEntitiesList = new ArrayList<EmployeeEntity>();

			for (Employee employee : emplist) {

				EmployeeEntity employeeEntity = employeeUtil.copydatafromemptoentity(employee);

				employeeEntitiesList.add(employeeEntity);
				employeeRepository.saveAll(employeeEntitiesList); // input iterable(entities) -- Iterable can be String
																	// , list
				isEmployeesSaved = "success";
			}
		}

		return isEmployeesSaved;
	}

	public EmployeeResponse getEmpId2(int id) {
		Employee emp = null;
		EmployeeEntity employeeEntity = employeeRepository.getEmployeeById(id);
		if (employeeEntity != null) {
			EmployeeUtil employeeUtil = new EmployeeUtil();
			emp = employeeUtil.copydatafromEntitytoemp(employeeEntity);

		} else {
			// if Employee not found --give user defined Exception ,for that we have to
			// create class
			EmployeenotfoundException enf = new EmployeenotfoundException("Employee not found by this Id");
			throw enf;
		}
		EmployeeResponse employeeResponse = new EmployeeResponse();
		employeeResponse.setData(emp);
		employeeResponse.setStatus("success");

		return employeeResponse;

	}

	public EmployeeResponse getEmpEmail(String mail) {
		if (!mail.contains("@")) {
			InvalidEmailException iee = new InvalidEmailException("EnterCorrect Email");
			throw iee;
		}
		EmployeeEntity employeeEntity = employeeRepository.findByEmail(mail);
		if (employeeEntity == null) {
			EmployeenotfoundException enf = new EmployeenotfoundException("Employee not exist with given Email");
			throw enf;
		}
		Employee emp = EmployeeUtil.copydatafromEntitytoemp(employeeEntity);
		EmployeeResponse employeeResponse = new EmployeeResponse();
		employeeResponse.setData(emp);
		return employeeResponse;
	}

	public EmployeeResponse getEmpByEnameAndEadd(String name, String address) {

		List<EmployeeEntity> employeeEntitieslist = employeeRepository.findEmpByEnameAndEadd(name, address);
		Employee employee = null;
		if (employeeEntitieslist != null && employeeEntitieslist.size() > 0) {
			for (EmployeeEntity employeeEntity : employeeEntitieslist) {
				employee = EmployeeUtil.copydatafromEntitytoemp(employeeEntity);
			}

		} else {
			EmployeenotfoundException enf = new EmployeenotfoundException(
					"Employee not found with the given name and address");
			throw enf;

		}

		EmployeeResponse employeeResponse = new EmployeeResponse();
		employeeResponse.setData(employee);

		return employeeResponse;
	}

	public Response2 deleteByEmail(String empMail) {
		String status = "failed to delete";
		Integer isEmpDeleted = employeeRepository.deleteByEmail(empMail);
		if (null != isEmpDeleted) // null we can write like this also
		{
			status = "Employee successfully Deleted";
		}
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("status", status);
		Response2 response2 = new Response2();
		response2.setData(hashMap);
		return response2;
	}

	public EmployeeResponse updateEmployeeDetails(int id, Employee employee) {
		EmployeeEntity employeeEntity;
		Employee updateEmp = null;
		EmployeeUtil employeeUtil= new EmployeeUtil();
		Optional<EmployeeEntity> optional= employeeRepository.findById(id);
		if(optional.isPresent())
		{
		employeeEntity= optional.get();
    	
		updateEmp = employeeUtil.copydatafromEntitytoemp(employeeEntity);
    	
		updateEmp.setEname(employee.getEname());
		updateEmp.setEmob(employee.getEmob());
		updateEmp.setEmail(employee.getEmail());
		updateEmp.setEadd(employee.getEadd());
    	}
		employeeEntity= employeeRepository.save(employeeUtil.copydatafromemptoentity(updateEmp));
		Employee emp = EmployeeUtil.copydatafromEntitytoemp(employeeEntity);
		EmployeeResponse employeeResponse = new EmployeeResponse();
		employeeResponse.setData(emp);
		return employeeResponse;
		
	}

}
