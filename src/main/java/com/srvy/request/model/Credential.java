package com.srvy.request.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Credential {

	private String username;
	
	private String password;
	
	@JsonCreator
	public Credential(@JsonProperty("username") String username,@JsonProperty("password") String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getUsername(){
		return this.username;
	}
	
	public String getPassword(){
		return this.password;
	}
}