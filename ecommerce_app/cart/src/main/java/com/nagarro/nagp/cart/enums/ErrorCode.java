package com.nagarro.nagp.cart.enums;

public enum ErrorCode {

	BAD_REQUEST("400", "Bad Request"), 
	INTERNAL_SERVER_ERROR("500", "Internal Server Error"),
	NO_DATA_DOUND("204", "No Data Found"),
	INVALID_USER("401", "Invalid Details");

	private String httpStatusCode;
	private String errorMessage;

	private ErrorCode(String statusCode, String errorMessage) {
		this.httpStatusCode = statusCode;
		this.errorMessage = errorMessage;
	}

	public String getStatusCode() {
		return this.httpStatusCode;
	}

	public String getErrorMessage() {
		return this.errorMessage;
	}

}
