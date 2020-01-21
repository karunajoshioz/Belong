package com.belong.customer.exception;

public class CustomerAlreadyExists extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerAlreadyExists(String message) {
		super(message);
	}
}
