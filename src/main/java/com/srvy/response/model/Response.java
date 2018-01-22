package com.srvy.response.model;

import java.util.Map;

public class Response {

	private String message;
	
	private int code;
	
	private Map<String,Object> data;
	
	private Response(){
		
	}
	
	public static ResponseBuilder Builder(){
		return new ResponseBuilder(new Response());
	}
	
	public void setMessage(String message){
		this.message = message;
	}
	
	public void setData(Map<String,Object> data){
		this.data = data;
	}
	
	public void add(String key,Object value){
		this.data.put(key, value);
	}
	
}
