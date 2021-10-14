package com.naresh.flipkart.service;

import java.util.List;

import com.naresh.flipkart.dto.CustomerDetailsDto;
import com.naresh.flipkart.dto.CustomerLoginRequestDto;
import com.naresh.flipkart.dto.CustomerLoginResponseDto;
import com.naresh.flipkart.dto.CustomerRequestDto;
import com.naresh.flipkart.dto.CustomerResponseDto;
import com.naresh.flipkart.dto.CustomerUpdateRequestDto;
import com.naresh.flipkart.exception.InvalidCustomerException;

public interface CustomerService {

	public CustomerResponseDto userRegister(CustomerRequestDto customerRequestDto);
	
	public CustomerLoginResponseDto customerLogin(CustomerLoginRequestDto customerLoginRequestDto) throws InvalidCustomerException;
	public List<CustomerDetailsDto> getAllCustomers() throws InvalidCustomerException;
	public CustomerResponseDto modifyCustomer(Integer customerId, CustomerUpdateRequestDto customerUpdateRequestDto);
	public CustomerResponseDto removeCustomerById(Integer customerId);
}
