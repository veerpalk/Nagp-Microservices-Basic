package com.nagarro.nagp.products.response;

import java.time.Instant;
import java.util.UUID;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ErrorResponse {

	private Instant timestamp;
	private String errorId;
	private String message;
	private HttpStatus status;
	private int errorCode;
	@JsonIgnore
	private String debugMessage;

	public ErrorResponse() {
		this.timestamp = Instant.now();
		this.errorId = UUID.randomUUID().toString();
	}

	public ErrorResponse(int errorCode, String message) {
		this();
		this.errorCode = errorCode;
		this.message = message;
	}

	public ErrorResponse(HttpStatus httpStatus) {
		this();
		this.status = httpStatus;
	}

	public ErrorResponse(HttpStatus httpStatus, String message, Throwable throwable) {
		this(httpStatus);
		this.message = message;
		this.debugMessage = throwable.getLocalizedMessage();
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public String getErrorId() {
		return errorId;
	}

	public void setErrorId(String errorId) {
		this.errorId = errorId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getDebugMessage() {
		return debugMessage;
	}

	public void setDebugMessage(String debugMessage) {
		this.debugMessage = debugMessage;
	}
	
	
	
}
