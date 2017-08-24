package com.srvy.util;

public interface Validator {

	boolean empty(Object obj);
	
	boolean ifNull(Object obj);
	
	int length(String source,int length);
	
	boolean range(Object source,int from,int to);
	
	boolean validEmail(String email);
	
	boolean validIp(String ip);
	
	String toLower(String source);
	
	String toUpper(String upper);
}
