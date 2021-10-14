package com.naresh.flipkart.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerDetailsDto {
	private Integer customerId;
	private String customerName;
	private String customerEmail;
	private String password;
	private LocalDate dob;
	private String gender;
	private String customerLocation;
	private Long mobileNo;
}
