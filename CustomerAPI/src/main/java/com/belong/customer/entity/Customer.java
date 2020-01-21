package com.belong.customer.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 */
@Table(name = "customer")
@Entity
public class Customer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "customer_id")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty
	private String customerId;
	
	@Column(name = "customer_Name")
	@JsonProperty
	private String customerName;
	
	//@ManyToOne
    //private CustomerDetails customerDetails;
	
	@OneToMany(targetEntity=Phones.class)
    private List<Phones> phones;
 
	
	
	public Customer() {
	}
	
	
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


	public List<Phones> getPhones() {
		return phones;
	}


	public void setPhones(List<Phones> phones) {
		this.phones = phones;
	}


	/**/


	




	

	

	
	
	

}
