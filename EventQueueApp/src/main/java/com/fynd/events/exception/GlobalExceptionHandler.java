package com.fynd.events.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.fynd.events.response.ErrorResponse;
import com.fynd.events.response.ResponseMessage;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

	ErrorResponse errResponse = null;
	ResponseMessage responseMessage = null;

	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<ResponseMessage> handleAllException() {
		responseMessage = new ResponseMessage(417, "failure", "Something went wrong, Try again..!!", null);
		return new ResponseEntity<>(responseMessage, HttpStatus.EXPECTATION_FAILED);
	}

}
