package com.customer.exception.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.customer.dto.ErrorMessageDto;
import com.customer.dto.SystemMessage;
import com.customer.exception.UserNotFoundException;
import com.customer.exception.handler.RestExceptionHandler;
import com.customer.services.ErrorMessageService;

@ExtendWith(MockitoExtension.class)
class RestExceptionHandlerTest {

	@Mock
	ErrorMessageService errorMessageService;

	@InjectMocks
	RestExceptionHandler exceptionHandler;

	@Test
	void test() {

		when(errorMessageService.get("ERROR_001")).thenReturn("User not found");

		ResponseEntity<Object> responseEntity = exceptionHandler
				.handleInternalException(new UserNotFoundException("ERROR_001"));
		assertEquals("400 BAD_REQUEST", responseEntity.getStatusCode().toString());
		ErrorMessageDto errorMessageDto = (ErrorMessageDto) responseEntity.getBody();
		List<SystemMessage> errorMessages = errorMessageDto.getMessage();
		assertEquals("ERROR_001", errorMessages.get(0).getMessageCode());
		assertEquals("User not found", errorMessages.get(0).getMessageDescription());
	}

}
