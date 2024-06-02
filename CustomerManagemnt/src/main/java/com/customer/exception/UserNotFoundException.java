package com.customer.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String code;
	
}
