package com.srvy.response.model;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseBuilder {

	private HttpStatus code;
	
	private Response response;
	
	public ResponseBuilder(Response response){
		this.response = response;
	}
	
	public HttpStatus getCode() {
		return code;
	}

	public ResponseBuilder setCode(HttpStatus code) {
		this.code = code;
		return this;
	}

	public ResponseBuilder setMessage(String message) {
		response.setMessage(message);
		return this;
	}

	public ResponseBuilder setData(Map<String, Object> data) {
		response.setData(data);
		return this;
	}
	
	public ResponseBuilder add(String key,Object value){
		response.add(key, value);
		return this;
	}
	
	public ResponseEntity<Response> build(){
		return new ResponseEntity<Response>(this.response,this.getCode());
	}
	
}
