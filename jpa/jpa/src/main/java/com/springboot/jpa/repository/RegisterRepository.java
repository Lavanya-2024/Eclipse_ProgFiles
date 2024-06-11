package com.springboot.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.jpa.entity.RegisterEntity;

@Repository
public interface RegisterRepository extends CrudRepository<RegisterEntity, Integer>{

public	RegisterEntity findByEmailAndPwd(String email, String pwd);
}
