package com.nagarro.nagp.account.exceptions.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nagarro.nagp.account.exceptions.RestClientException;
import com.nagarro.nagp.account.response.ErrorResponse;
import com.nagarro.nagp.account.exceptions.DataNotFoundException;
import com.nagarro.nagp.account.exceptions.InvalidUserException;
import com.nagarro.nagp.account.exceptions.OrderNotPLacedException;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(value = RestClientException.class)
	ResponseEntity<ErrorResponse> handleMyRestTemplateException(RestClientException ex,HttpServletRequest request) {
//		LOGGER.error("An error happened while calling {} Downstream API: {}", ex.toString());
		ErrorResponse errorResponse=new ErrorResponse(ex.getStatus(), ex.getMessage(), ex);
		return new ResponseEntity<>(errorResponse,ex.getStatus());
	}	
	
	@ExceptionHandler(value= InvalidUserException.class)
	ResponseEntity<ErrorResponse> handleInvalidUserException(InvalidUserException ex)
	{
		ErrorResponse errorResponse=new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(),ex);
        return ResponseEntity.status(errorResponse.getStatus()).body(errorResponse);
	}
	
	@ExceptionHandler(value= DataNotFoundException.class)
	ResponseEntity<ErrorResponse> handleDataNotFoundException(DataNotFoundException ex)
	{
		ErrorResponse errorResponse=new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(),ex);
        return ResponseEntity.status(errorResponse.getStatus()).body(errorResponse);
	}
	
	@ExceptionHandler(value= OrderNotPLacedException.class)
	ResponseEntity<ErrorResponse> handleOrderNotPLacedException(OrderNotPLacedException ex)
	{
		ErrorResponse errorResponse=new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(),ex);
        return ResponseEntity.status(errorResponse.getStatus()).body(errorResponse);
	}

}
