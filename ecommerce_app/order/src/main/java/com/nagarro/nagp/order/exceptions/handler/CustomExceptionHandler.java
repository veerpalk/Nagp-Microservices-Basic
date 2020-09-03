package com.nagarro.nagp.order.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nagarro.nagp.order.exceptions.DataNotFoundException;
import com.nagarro.nagp.order.response.ErrorResponse;

@ControllerAdvice
public class CustomExceptionHandler {

	
	@ExceptionHandler(value= DataNotFoundException.class)
	ResponseEntity<ErrorResponse> handleDataNotFoundException(DataNotFoundException ex)
	{
		ErrorResponse errorResponse=new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(),ex);
        return ResponseEntity.status(errorResponse.getStatus()).body(errorResponse);
	}
	

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception ex) {

		ErrorResponse errorResponse=new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(),ex);
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

