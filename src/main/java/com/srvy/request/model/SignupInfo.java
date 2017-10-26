package com.srvy.request.model;

import java.util.List;

public class SignupInfo {

	private String name;
	
	private long dob;
	
	private String emailId;
	
	private String password;
	
	private String aboutMe;
	
	private List<TopicInfo> topics;

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

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public List<TopicInfo> getTopics() {
		return topics;
	}

	public void setTopics(List<TopicInfo> topics) {
		this.topics = topics;
	}
	
}
