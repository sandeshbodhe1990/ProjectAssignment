package com.customer.services;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ErrorMessageService {

	private final MessageSource messageSource;
	
	public String get(String key) {
		return messageSource.getMessage(key,null,Locale.JAPAN);
	}
}
