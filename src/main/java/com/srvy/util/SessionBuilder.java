package com.srvy.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionBuilder {
	
	private HttpSession session;
	
	private ResponseBuilder builder;
	
	public SessionBuilder(HttpServletRequest request,ResponseBuilder builder){
		this.session = request.getSession();
		this.builder = builder;
	}
	
	public SessionBuilder addAttribute(String key,Object value){
		session.setAttribute(key, value);
		return this;
	}
	
	public ResponseBuilder done(){
		return builder;
	}
	
}
