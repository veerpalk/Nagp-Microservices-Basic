package com.nagarro.nagp.payment.enums;

public enum ErrorCode {

	BAD_REQUEST("400", "Bad Request"), 
	INTERNAL_SERVER_ERROR("500", "Internal Server Error"),
	NO_DATA_DOUND("400", "No Data Found"),
	PAYMENT_TYPE_NOT_SUPPORTED("400","Payment Type Not Supported!! Available Options ->[PAYTM , CREDIT_CARD, CASH_ON_DELIVERY]");

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
