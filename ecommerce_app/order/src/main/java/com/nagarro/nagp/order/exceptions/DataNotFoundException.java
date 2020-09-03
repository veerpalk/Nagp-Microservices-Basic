package com.nagarro.nagp.order.exceptions;

import com.nagarro.nagp.order.enums.ErrorCode;

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