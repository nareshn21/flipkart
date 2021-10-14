package com.naresh.flipkart.exception;

public class InvalidCustomerException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InvalidCustomerException(){
		
	}
	public InvalidCustomerException(String message) {
		super(message);
	}

}
