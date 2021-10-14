package com.naresh.flipkart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naresh.flipkart.dto.CustomerDetailsDto;
import com.naresh.flipkart.dto.CustomerLoginRequestDto;
import com.naresh.flipkart.dto.CustomerLoginResponseDto;
import com.naresh.flipkart.dto.CustomerRequestDto;
import com.naresh.flipkart.dto.CustomerResponseDto;
import com.naresh.flipkart.dto.CustomerUpdateRequestDto;
import com.naresh.flipkart.entity.Customer;
import com.naresh.flipkart.exception.InvalidCustomerException;
import com.naresh.flipkart.repository.CustomerRepository;
import com.naresh.flipkart.util.ApiConstant;
@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerRepository customerRepository;
	@Override
	public CustomerResponseDto userRegister(CustomerRequestDto customerRequestDto) {
		CustomerResponseDto customerResponseDto= new CustomerResponseDto();
		Customer customer=new Customer();
		/*
		 * customer.setCustomerName(customerRequestDto.getCustomerName());
		 * customer.setCustomerEmail(customerRequestDto.getCustomerEmail());
		 * customer.setCustomerLocation(customerRequestDto.getCustomerLocation());
		 * customer.setDob(customerRequestDto.getDob());
		 * customer.setGender(customerRequestDto.getGender());
		 * customer.setMobileNo(customerRequestDto.getMobileNo());
		 * customer.setPassword(customerRequestDto.getPassword());
		 */
		BeanUtils.copyProperties(customerRequestDto, customer);
		customerRepository.save(customer);
		customerResponseDto.setMessage(ApiConstant.USER_CREATED);
		customerResponseDto.setStatusCode(201);
		return customerResponseDto;
	}
	@Override
	public CustomerLoginResponseDto customerLogin(CustomerLoginRequestDto customerLoginRequestDto) throws InvalidCustomerException {
		CustomerLoginResponseDto customerLoginResponseDto= new CustomerLoginResponseDto();;
	Optional<Customer> optionalCustomer=customerRepository.findByCustomerEmail(customerLoginRequestDto.getCustomerEmail());
	if(optionalCustomer.isPresent()) {
		if(optionalCustomer.get().getCustomerEmail().equals(customerLoginRequestDto.getCustomerEmail()) && optionalCustomer.get().getPassword().equalsIgnoreCase(customerLoginRequestDto.getPassword())) {
			customerLoginResponseDto.setCustomerName(optionalCustomer.get().getCustomerName());
			customerLoginResponseDto.setMessage(ApiConstant.LOGIN_SUCCESS);
			customerLoginResponseDto.setStatusCode(200);
		}else {
			customerLoginResponseDto.setMessage(ApiConstant.LOGIN_FAILURE);
			customerLoginResponseDto.setStatusCode(204);
		}
	}else {
		throw new InvalidCustomerException(ApiConstant.CUSTOMER_NOT_FOUND);
	}
		return customerLoginResponseDto;
	}
	@Override
	public List<CustomerDetailsDto> getAllCustomers() throws InvalidCustomerException {
		
		List<Customer> customers=customerRepository.findAll();
		List<CustomerDetailsDto> customerDeatails=new ArrayList<>();
		if(customers!=null) {
			for(Customer customer:customers) {
				CustomerDetailsDto customerDetailsDto=new CustomerDetailsDto();
				BeanUtils.copyProperties(customer, customerDetailsDto);
				customerDeatails.add(customerDetailsDto);
			}
			
		}else {
			throw new InvalidCustomerException(ApiConstant.CUSTOMER_NOT_FOUND);
		}
		return customerDeatails;
	}
	@Override
	public CustomerResponseDto modifyCustomer(Integer customerId, CustomerUpdateRequestDto customerUpdateRequestDto) {
		CustomerResponseDto customerResponseDto=null;
		Optional<Customer> user=customerRepository.findById(customerId);
		if(user!=null) {
				customerResponseDto=new CustomerResponseDto();
				Customer customer=user.get();
				BeanUtils.copyProperties(customerUpdateRequestDto, customer);
				customerRepository.save(customer);
				customerResponseDto.setMessage("success");
				customerResponseDto.setStatusCode(200);
			}
			
		
		return customerResponseDto;
	}
	@Override
	public CustomerResponseDto removeCustomerById(Integer customerId) {
		CustomerResponseDto customerResponseDto=null;
		Optional<Customer> user=customerRepository.findById(customerId);
		if(user.isPresent()) {
			customerResponseDto=new CustomerResponseDto();
			customerRepository.deleteById(customerId);
			customerResponseDto.setMessage("deleted successful");
			customerResponseDto.setStatusCode(200);

		}
		return customerResponseDto;
	}

}
