package com.belong.customer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.belong.customer.dto.CustomerDTO;
import com.belong.customer.exception.CustomerException;
import com.belong.customer.service.CustomerService;

/**
 * @author 
 *
 */
@RestController
@RequestMapping(path = "/api/v1/customer/")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping(path="activate")
	public ResponseEntity<?> activateCustomer(@RequestBody CustomerDTO customerDTO, HttpServletRequest request, HttpServletResponse response)
		throws CustomerException{
		String responseCode = customerService.activateUser(customerDTO);
		
		return new ResponseEntity<>("User successfully activated",HttpStatus.OK);
	}
	
	
	@GetMapping(path="{customerId}")
	public ResponseEntity<?> getAllCustomerInfo(@PathVariable String customerId ,HttpServletRequest request, HttpServletResponse response) throws CustomerException{
		List<CustomerDTO>  customerList = customerService.getAllCustomerInfo(customerId);
		return new ResponseEntity<>(customerList,HttpStatus.OK);
		
	}
	
	
	
}
