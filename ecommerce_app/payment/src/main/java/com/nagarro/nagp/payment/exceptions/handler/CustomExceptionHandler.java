package com.nagarro.nagp.payment.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nagarro.nagp.payment.exceptions.PaymentTypeNotSupportedException;
import com.nagarro.nagp.payment.response.ErrorResponse;

@ControllerAdvice
public class CustomExceptionHandler {

	
	@ExceptionHandler(value= PaymentTypeNotSupportedException.class)
	ResponseEntity<ErrorResponse> PaymentTypeNotSupportedException(PaymentTypeNotSupportedException ex)
	{
		ErrorResponse errorResponse=new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(),ex);
        return ResponseEntity.status(errorResponse.getStatus()).body(errorResponse);
	}

}
