package com.springboot.jpa.onetomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;




@RestController("/user")
public class UserController {
	@Autowired
	private UserService userSerivice;
	
	@PostMapping("/createuser")//http:://localhost;2030/user/createuser
	public ResponseEntity<Void> createuser(@RequestBody User user){
		return new ResponseEntity<Void>(userSerivice.createuser(user)? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR);	
	}

}
