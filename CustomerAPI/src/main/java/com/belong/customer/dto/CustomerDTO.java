package com.belong.customer.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.belong.customer.entity.Phones;

/**
 *
 */
public class CustomerDTO implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String customerId;
    private String customerName;
    private List<Phones> phoneDtls;
    
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public List<Phones> getPhoneDtls() {
		return phoneDtls;
	}
	public void setPhoneDtls(List<Phones> phoneDtls) {
		this.phoneDtls = phoneDtls;
	}
	
	
    
    
	
    
	

}
