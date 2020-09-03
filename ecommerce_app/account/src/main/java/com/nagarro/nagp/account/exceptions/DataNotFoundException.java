package com.nagarro.nagp.account.exceptions;

import com.nagarro.nagp.account.enums.ErrorCode;

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
