package com.naresh.flipkart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.flipkart.dto.CustomerDetailsDto;
import com.naresh.flipkart.dto.CustomerLoginRequestDto;
import com.naresh.flipkart.dto.CustomerLoginResponseDto;
import com.naresh.flipkart.dto.CustomerRequestDto;
import com.naresh.flipkart.dto.CustomerResponseDto;
import com.naresh.flipkart.dto.CustomerUpdateRequestDto;
import com.naresh.flipkart.exception.InvalidCustomerException;
import com.naresh.flipkart.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/customers")
	public CustomerResponseDto userRegister(@RequestBody CustomerRequestDto customerRequestDto) {
		CustomerResponseDto customerResponseDto=customerService.userRegister(customerRequestDto);
	return customerResponseDto;
	}
	
	@PostMapping("/customers/login")
	public CustomerLoginResponseDto customerLogin(CustomerLoginRequestDto customerLoginRequestDto) throws InvalidCustomerException {
		CustomerLoginResponseDto customerLoginResponseDto=customerService.customerLogin(customerLoginRequestDto);
	return customerLoginResponseDto;
	}
	@GetMapping("/customers")
	public List<CustomerDetailsDto> getAllCustomers() throws InvalidCustomerException {
		List<CustomerDetailsDto> customerDetailsDto=customerService.getAllCustomers();
	return customerDetailsDto;
	}
	@PutMapping("/customers/{customerId}")
	public CustomerResponseDto modifyCustomer(@PathVariable Integer customerId, @RequestBody CustomerUpdateRequestDto customerUpdateRequestDto){
		CustomerResponseDto customerResponseDto=customerService.modifyCustomer(customerId, customerUpdateRequestDto);
		return customerResponseDto;
	}
	@DeleteMapping("/customer/{customerId}")
	public CustomerResponseDto removeCustomerById(@PathVariable Integer customerId) {
		CustomerResponseDto customerResponseDto=customerService.removeCustomerById(customerId);
		return customerResponseDto;
	}
	
}

