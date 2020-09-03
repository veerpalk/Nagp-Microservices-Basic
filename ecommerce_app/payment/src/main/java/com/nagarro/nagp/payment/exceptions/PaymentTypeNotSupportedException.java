package com.nagarro.nagp.payment.exceptions;

import com.nagarro.nagp.payment.enums.ErrorCode;

public class PaymentTypeNotSupportedException extends RuntimeException{
	
private final ErrorCode errorCode;
	
	public PaymentTypeNotSupportedException(ErrorCode errorCode)
	{
		super(errorCode.getErrorMessage());
		this.errorCode = errorCode;
	}
	
	public ErrorCode getErrorCode()
	{
		return this.errorCode;
	}

}
