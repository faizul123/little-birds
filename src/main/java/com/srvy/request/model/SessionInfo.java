package com.srvy.request.model;

import com.srvy.model.Profile;

public class SessionInfo {
	
	private String sessionId;
	
	private String userId;
	
	private String username;
	
	private String name;
	
	public SessionInfo(Profile profile){
		setUserId(profile.getId());
		setName(profile.getFistName() + profile.getLastName());
		setUsername(profile.getEmailId());
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
