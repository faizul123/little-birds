package com.srvy.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.srvy.exception.model.Error;

@ControllerAdvice
public class ExceptionResolver {

	
	@ExceptionHandler(ServiceFailureException.class)
	public Error handleError(ServiceFailureException e){
		return new Error(503, e.getErrorMessage(), "", "");
	}
	
}
