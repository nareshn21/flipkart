package com.naresh.flipkart.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerLoginResponseDto {
	private String customerName;
	private String message;
	private Integer statusCode;
}
