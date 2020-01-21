package com.belong.customer.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.belong.customer.dto.CustomerDTO;
import com.belong.customer.entity.Customer;
import com.belong.customer.exception.CustomerAlreadyExists;


public interface CustomerService {
	public  List<CustomerDTO> getAllCustomerInfo(String customerId);
	public String activateUser(CustomerDTO customerDTO);
	
	
	
	

}
