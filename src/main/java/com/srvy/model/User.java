package com.srvy.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Unindex;
import com.srvy.request.model.Credential;
import com.srvy.request.model.SignupInfo;
import com.srvy.util.Utility;

@Entity
@Index
public class User {

	@Id
	private String id;
	
	private String username;
	
	@Unindex
	private String password;
	
	public User() {
		
	}
	
	public User(SignupInfo info){
		this.id = Utility.randomUUID();
		this.username = info.getEmailId().toLowerCase();
		setPassword(info.getPassword());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public boolean isPasswordMatch(Credential credential){
		return (this.password.equals(credential.getPassword()));
	}
	
	public void setPassword(String password) {
		
		this.password = Utility.SHA256HEX.doHash(password);
	}
	
}
