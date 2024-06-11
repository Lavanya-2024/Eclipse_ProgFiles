package com.springboot.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.jpa.entity.AmazonUserEntity;

@Repository
public interface AmazonUserRepository extends CrudRepository<AmazonUserEntity, Long >{

}
