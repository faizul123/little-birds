package com.srvy.exception;


public class ServiceFailureException extends IllegalAccessError {

	private static final long serialVersionUID = 8260031889253684316L;

	private String message;
	
	public ServiceFailureException(String message){
		super(message);
	}
	
	public String getErrorMessage(){
		return message;
	}
	
}
