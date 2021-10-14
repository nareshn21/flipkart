package com.naresh.flipkart.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerLoginRequestDto {
	
	private String customerEmail;
	private String password;

}
