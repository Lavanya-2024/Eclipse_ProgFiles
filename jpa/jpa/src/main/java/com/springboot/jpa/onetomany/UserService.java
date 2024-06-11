package com.springboot.jpa.onetomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public boolean createuser(User user) {
		// TODO Auto-generated method stub
		UserEntity userEntity = UserUtil.copyDataFromModelToUserEntity(user);
		return userRepository.save(userEntity) == null ? false : true;
	}

}
