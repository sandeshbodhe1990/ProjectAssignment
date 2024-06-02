package com.customer.exception.handler;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.customer.dto.ErrorMessageDto;
import com.customer.dto.SystemMessage;
import com.customer.exception.UserNotFoundException;
import com.customer.services.ErrorMessageService;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	private final ErrorMessageService messages;

	public RestExceptionHandler(ErrorMessageService messages) {
		super();
		this.messages = messages;
	}

	@ExceptionHandler(UserNotFoundException.class)
	protected ResponseEntity<Object> handleInternalException(UserNotFoundException e) {
		ErrorMessageDto errormessageDto = new ErrorMessageDto();

		errormessageDto.setMessage(createSystemMessage(e.getCode()));

		return new ResponseEntity<>(errormessageDto, HttpStatus.BAD_REQUEST);
	}

	private List<SystemMessage> createSystemMessage(String code) {
		String message = messages.get(code);
		return Arrays.asList(new SystemMessage(code, message));
	}
}
