package com.nagarro.nagp.account.exceptions;

import org.springframework.http.HttpStatus;

public class RestClientException extends RuntimeException {

	private HttpStatus status;
	private String message;

	public RestClientException(HttpStatus statusCode, String message) {
		super(message);
		this.status = statusCode;
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}
	
	

}
