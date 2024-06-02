package com.customer.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.MessageSource;

import com.customer.services.ErrorMessageService;

@ExtendWith(MockitoExtension.class)
class ErrorMessageServiceTest {
	
	@Mock
	MessageSource messageSource;
	
	@InjectMocks
	ErrorMessageService errorMessageService;

	@Test
	void test_001() {
		when(messageSource.getMessage(Mockito.anyString() ,Mockito.any(),Mockito.any())).thenReturn("User not found");
		
		String message = errorMessageService.get("ERROR_001");
		assertEquals("User not found", message);
	}

}
