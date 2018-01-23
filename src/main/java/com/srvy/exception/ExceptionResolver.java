package com.srvy.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.srvy.exception.model.Error;
import com.srvy.util.Response;

@ControllerAdvice
public class ExceptionResolver {

	
	@ExceptionHandler(ServiceFailureException.class)
	public Error handleError(ServiceFailureException e){
		return new Error(503, e.getErrorMessage(), "", "");
	}
	
	
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<Map<String,Object>> handleValidationError(ValidationException e){
		return Response
				.newBuilder()
				.status(HttpStatus.BAD_REQUEST)
				.add("error",new Error(400, e.getMessage(), "", ""))
				.build();
	}
	
	public ResponseEntity<Map<String,Object>> handleClassNotFoundException(ClassNotFoundException e){
		return Response.newBuilder().status(HttpStatus.BAD_REQUEST).add("error", new Error(400,e.getMessage(),"","")).build();
	}
	
}
