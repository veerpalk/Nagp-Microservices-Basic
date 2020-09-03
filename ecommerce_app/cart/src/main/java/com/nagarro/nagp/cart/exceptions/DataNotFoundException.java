package com.nagarro.nagp.cart.exceptions;

import com.nagarro.nagp.cart.enums.ErrorCode;

public class DataNotFoundException extends RuntimeException{
	
private final ErrorCode errorCode;
	
	public DataNotFoundException(ErrorCode errorCode)
	{
		super(errorCode.getErrorMessage());
		this.errorCode = errorCode;
	}
	
	public ErrorCode getErrorCode()
	{
		return this.errorCode;
	}

}