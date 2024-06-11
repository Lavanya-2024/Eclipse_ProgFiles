package com.springboot.jpa.service;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.jpa.Util.JwtTokenConfig;
import com.springboot.jpa.entity.RegisterEntity;
import com.springboot.jpa.model.Register;
import com.springboot.jpa.repository.RegisterRepository;

import io.jsonwebtoken.Claims;

@Service
public class RegisterService {
	@Autowired
	RegisterRepository  registerRepository;
	

	public int saveuser(Register register) throws IllegalAccessException, InvocationTargetException {
		RegisterEntity registerEntity = new RegisterEntity();
		
		BeanUtils.copyProperties(registerEntity, register);
		
		return registerRepository.save(registerEntity)==null?0:1;
	}


	public HashMap<String, Object> login(String email, String pwd) throws IllegalAccessException, InvocationTargetException {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
	RegisterEntity registerEntity =	registerRepository.findByEmailAndPwd(email, pwd);
	map.put("status", registerEntity == null ? null : "Login successfully");
	Register register = new Register();
	if(registerEntity!=null) {
		BeanUtils.copyProperties(register, registerEntity);
		map.put("token", JwtTokenConfig.createJWT(register.getAcctid()+"", "IBM", register.getName(), 1000*60*60, register));	
		
	}
	
		return map;
	}


	public Register getuserbyheadertoken(String token) throws Exception {

		Claims claims=	validateToken(token);
		String id=claims.getId();	// It returns string so 
		Optional<RegisterEntity> registerEntityOptional =	registerRepository.findById(Integer.parseInt(id));
		Register register =null;
		if(registerEntityOptional.isPresent()) {
			register =new Register();
			RegisterEntity registerEntity =	registerEntityOptional.get();
			BeanUtils.copyProperties(register, registerEntity);
		}
		else {
			throw new Exception("Invalid user");
		}
		return register;
		
		
	}
	
	
	public Claims validateToken(String token) throws Exception {
		
		if(null == token || token.trim() == ""  ) {
			throw new  Exception("Invalid Token");	
			}
		return JwtTokenConfig.decodeJWT(token.replace("Bearer", "").trim());
	}
	
	

}
