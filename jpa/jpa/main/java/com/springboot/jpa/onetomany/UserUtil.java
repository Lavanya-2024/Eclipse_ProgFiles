package com.springboot.jpa.onetomany;

import java.util.HashSet;
import java.util.Set;



public class UserUtil {
	
	public static UserEntity copyDataFromModelToUserEntity(User user) {
		UserEntity userEntity =new UserEntity();
		userEntity.setAddress(user.getAddress());
		userEntity.setAge(user.getAge());
		userEntity.setEmail(user.getEmail());
		userEntity.setFname(user.getFname());
		userEntity.setId(user.getId());
		userEntity.setLname(user.getLname());
		Set<CardDetails> setCardDetails=user.getCardDetails();
		
		Set<CardDetailsEntity> setCardDetailsEntity =new HashSet<CardDetailsEntity>();
		for( CardDetails cardDetails:setCardDetails) {
			CardDetailsEntity cardDetailsEntity =new CardDetailsEntity();
			cardDetailsEntity.setCardid(cardDetails.getCardid());
			cardDetailsEntity.setCardnumber(cardDetails.getCardnumber());
			cardDetailsEntity.setCardType(cardDetails.getCardType());
			cardDetailsEntity.setNameonthecard(cardDetails.getNameonthecard());
			cardDetailsEntity.setUser(userEntity);
			setCardDetailsEntity.add(cardDetailsEntity);
			
		}
		userEntity.setCardDetails(setCardDetailsEntity);
		
		return userEntity;
		
	}

}
