package com.nagarro.nagp.account.exceptions;

import com.nagarro.nagp.account.enums.ErrorCode;

public class OrderNotPLacedException extends RuntimeException{
	
private final ErrorCode errorCode;
	
	public OrderNotPLacedException(ErrorCode errorCode)
	{
		super(errorCode.getErrorMessage());
		this.errorCode = errorCode;
	}
	
	public ErrorCode getErrorCode()
	{
		return this.errorCode;
	}
}


