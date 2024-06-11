package com.springboot.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.jpa.entity.OrderEntity;

@Repository
public interface OrderEntityRepository extends CrudRepository<OrderEntity, Long>{

}
