
package com.springboot.jpa.Consumer;

import java.net.URI;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ConsumingJavaClass {
	public static void main(String[] args) {
		ConsumingJavaClass consumingJavaClass = new ConsumingJavaClass();
		// consumingJavaClass.welcome();
		// consumingJavaClass.signup();
		//consumingJavaClass.saveperson();
		// consumingJavaClass.getallpersondetails();
		consumingJavaClass.deletebyid(5);
		// consumingJavaClass.getpersonbyid(2); // returns null check
		// consumingJavaClass.deletebyemail("lasya@gmail.com");
		//consumingJavaClass.updatepersondetails(3);
	   //consumingJavaClass.deletebyemail22("rahul@gmail.com");
	   
	
	}

	/*
	 * public String welcome() // http://localhost:2050/welcome { RestTemplate
	 * restTemplate = new RestTemplate(); String string =
	 * restTemplate.getForObject("http://localhost:2050/welcome", String.class);
	 * System.out.println(string); return string; }
	 */

	// http://localhost:2050/signup

	/*
	 * public void signup() { RestTemplate restTemplate = new RestTemplate();
	 * 
	 * // URI uri = new URI("http://localhost:2050/signup"); PersonModel1
	 * personModel1 = new PersonModel1();
	 * 
	 * personModel1.setFname("Ganga"); personModel1.setLname("darani");
	 * personModel1.setGender("female"); personModel1.setEmail("ganga@gmail.com");
	 * personModel1.setMobile("888888"); personModel1.setPassword("12345");
	 * 
	 * ResponseModel1 responseModel1 =
	 * restTemplate.postForObject("http://localhost:2050/signup", personModel1,
	 * ResponseModel1.class); System.out.println(responseModel1);
	 * 
	 * }
	 */

	// saveperson(PostMapping) in PersonController
	public void saveperson() {
		RestTemplate restTemplate = new RestTemplate();

		PersonModel2 personModel2 = new PersonModel2();

		personModel2.setFname("lasya");
		personModel2.setLname("karan");
		personModel2.setAge(25);
		personModel2.setEmail("lasya@gmail.com");
		personModel2.setAddress("hyd");

		ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost:2050/saveperson",
				personModel2, String.class);
		String response = responseEntity.getBody();

		System.out.println(response);
	}

	// getallpersondetails in PersonController
	public void getallpersondetails() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ResponseModel2> responseEntity = restTemplate
				.getForEntity("http://localhost:2050/getallpersondetails", ResponseModel2.class);

		ResponseModel2 responseModel2 = responseEntity.getBody();

		List<PersonModel2> listofpersons = responseModel2.getData();

		for (Iterator iterator = listofpersons.iterator(); iterator.hasNext();) {
			PersonModel2 personModel2 = (PersonModel2) iterator.next();
			System.out.println(personModel2);
		}

	}

	// getpersonbyid in PersonController(Get)
	// http://localhost:2050/getpersonbyid?personId=1
	public void getpersonbyid(long personid) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:2050/getpersonbyid?personId=" + personid;
		ResponseEntity<Responsemodel3> responseEntity = restTemplate.getForEntity(url, Responsemodel3.class);
		System.out.println(responseEntity.getBody().getData());

	}

	// @GetMapping("/deletebyid/{personId}")
	// http://localhost:2050/deletebyid/1
	public void deletebyid(long personid) {
		RestTemplate restTemplate = new RestTemplate();
		// String url = "http://localhost:2050/deletebyid/{"+personid+"}";
		restTemplate.delete("http://localhost:2050/deletebyid/" + personid);
		System.out.println("Person Deleted successfully");

	}

	public void deletebyemail(String email) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete("http://localhost:2050/deletebyemail?email=" + email);
		System.out.println("Person Deleted successfully");
	}
	
	public void deletebyemail22(String email) {
		RestTemplate restTemplate = new RestTemplate();
		//restTemplate.delete("http://localhost:2050/deletebyemail?email=" + email);
		String url = "http://localhost:2050/deletebyemail?email="+email;
		restTemplate.exchange(url, HttpMethod.DELETE,null,String.class);
		System.out.println("Person Deleted successfully");
	}
	

	// @PutMapping("/updatepersondetails")--http://localhost:2050/updatepersondetails?personId=3
	public void updatepersondetails(long personid) {
		RestTemplate restTemplate = new RestTemplate();
		PersonModel2 personModel2 = new PersonModel2();
		personModel2.setFname("jagadish");
		personModel2.setLname("kumar");
		personModel2.setEmail("jagadish@gmail.com");
		personModel2.setAddress("tamilnadu");
		restTemplate.put("http://localhost:2050/updatepersondetails?personId=" + personid, personModel2);
		System.out.println("person details is updated successfully");
	}
	
	
}
