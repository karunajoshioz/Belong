package com.belong.customer.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.belong.customer.dto.CustomerDTO;
import com.belong.customer.entity.Customer;
import com.belong.customer.entity.Phones;
import com.belong.customer.repository.CustomerRepository;
import com.belong.customer.repository.PhonesRepository;

@Service
public class CustomerServiceImpl implements CustomerService {


	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private PhonesRepository phonesRepo;

	@Override
	public List<CustomerDTO> getAllCustomerInfo(String customerId) {
		List<CustomerDTO> customerList = new ArrayList<CustomerDTO>();
		try {
			if(customerId.equalsIgnoreCase("all")) {
				List<Customer> customers = customerRepo.findAll();
				Iterator<Customer> itr = customers.iterator();
				while(itr.hasNext()){
					Customer customer = itr.next();
					
					CustomerDTO custDTO = new CustomerDTO();
					custDTO.setCustomerId(customer.getCustomerId());
					custDTO.setCustomerName(customer.getCustomerName());
					
					custDTO.setPhoneDtls(customer.getPhones());
					customerList.add(custDTO);
				}
			}
			else{
				Optional<Customer> customers = customerRepo.findById(customerId);
				//Iterator<Customer> itr = customers.iterator();
				//while(itr.hasNext()){
					Customer customer = customers.get();
					
					CustomerDTO custDTO = new CustomerDTO();
					custDTO.setCustomerId(customer.getCustomerId());
					custDTO.setCustomerName(customer.getCustomerName());
					
					custDTO.setPhoneDtls(customer.getPhones());
					customerList.add(custDTO);
				//}
			}
			return customerList;
			
		} catch (Exception e) {
			System.out.println("Error occurred while loading object list from file " + e);
			return Collections.emptyList();
		}
	}

	public String activateUser(CustomerDTO customerDTO)
	{	
		Customer customer = new Customer();
		List<Phones> phonesList = new ArrayList<Phones>();
		
		customer.setCustomerName(customerDTO.getCustomerName());
		customer.setCustomerId(customerDTO.getCustomerId());
		
		Iterator<Phones> itr = customerDTO.getPhoneDtls().iterator();
		while(itr.hasNext()){
			Phones custDtls = itr.next();
			
			Phones phone = new Phones();
			phone.setPhoneNo(custDtls.getPhoneNo());
			phonesList.add(phone);
			phonesRepo.save(phone);
		}
		customer.setPhones(phonesList);
		customerRepo.save(customer);
		return HttpStatus.OK.toString();
	}
	
}
