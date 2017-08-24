package com.srvy.util;

import com.srvy.exception.ValidationException;


public class Validation extends AbstractValidator {

	public Validation() {
		
	}
	
	
	public Validation isEmpty(Object obj,String error) {
		if(super.empty(obj))
			return this;
		else
			throw new ValidationException(400, error);
	}
	
}