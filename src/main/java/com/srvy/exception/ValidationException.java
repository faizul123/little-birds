package com.srvy.exception;

import com.srvy.exception.model.Error;

public class ValidationException extends IllegalArgumentException {

	
	private static final long serialVersionUID = 1L;

	private Error error;	
	
	public ValidationException(int code,String message){
		super(message);
		error = new Error(code, message, null, null);
	}
	
	public ValidationException(int code,String message,String desc, String info){
		super(message);
		error = new Error(code, message, desc, info);
	}
	
	public Error getError(){
		return error;
	}
	
}
