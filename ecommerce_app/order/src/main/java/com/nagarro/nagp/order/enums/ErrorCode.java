package com.nagarro.nagp.order.enums;

public enum ErrorCode {

	BAD_REQUEST("400", "Bad Request"), 
	INTERNAL_SERVER_ERROR("500", "Internal Server Error"),
	NO_DATA_DOUND("400", "No Data Found"),
	NO_ORDER_FOUND("400","No Order Found"),
	INVALID_USER("400", "Invalid Details");

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
