package com.srvy.request.model;

public class SignupInfo {

	private String name;
	
	private long dob;
	
	private String emailId;
	
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getDob() {
		return dob;
	}

	public void setDob(long dob) {
		this.dob = dob;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
