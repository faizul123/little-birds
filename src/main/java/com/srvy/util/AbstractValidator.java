package com.srvy.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AbstractValidator implements Validator {

	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	@Override
	public boolean empty(Object obj) {
		
		return false;
	}
	
	@Override
	public boolean ifNull(Object obj) {
		
		return false;
	}

	@Override
	public int length(String source, int length) {
		
		return 0;
	}

	@Override
	public boolean range(Object source, int from, int to) {
		
		return false;
	}

	@Override
	public boolean validEmail(String email) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(email);
		return matcher.find();
	}

	@Override
	public boolean validIp(String ip) {
		
		return false;
	}

	@Override
	public String toLower(String source) {
		
		return null;
	}

	@Override
	public String toUpper(String upper) {
		
		return null;
	}

}
