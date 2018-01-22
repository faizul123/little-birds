package com.srvy.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseBuilder {

	
	private Map<String,Object> map = new HashMap<String,Object>();
	
	private HttpStatus status = HttpStatus.OK;
	
	public ResponseBuilder status(HttpStatus status){
		this.status = status;
		return this;
	}
	
	public ResponseBuilder add(String key,Object value){
		this.map.put(key, value);
		return this;
	}
	
	public ResponseBuilder reset(){
		map.clear();
		status = HttpStatus.OK;
		return this;
	}
	
	public SessionBuilder newSession(HttpServletRequest request){
		return new SessionBuilder(request, this);
	}
	
	public ResponseEntity<Map<String,Object>> build(){
		return new ResponseEntity<Map<String,Object>>(map,status);
	}
	
}
