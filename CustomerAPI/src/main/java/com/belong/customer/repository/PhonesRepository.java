package com.belong.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.belong.customer.entity.Customer;
import com.belong.customer.entity.Phones;

/**
 *
 */
@Repository
public interface PhonesRepository extends JpaRepository<Phones, Long>{
	

}
