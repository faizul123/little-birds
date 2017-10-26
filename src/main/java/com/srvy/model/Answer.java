package com.srvy.model;

import java.util.List;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Serialize;

@Entity(name="Answers")
@Index
public class Answer {

	@Id
	private String uuid;
	
	private String id;
	
	private String questionId;
	
	private String userId;
	
	@Serialize(zip=true)
	private List<Option> options;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Option> getOption() {
		return options;
	}

	public void setOption(List<Option> options) {
		this.options = options;
	}
	
}
