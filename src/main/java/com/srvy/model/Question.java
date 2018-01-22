package com.srvy.model;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Serialize;
import com.googlecode.objectify.annotation.Unindex;

@Entity(name="Questions")
@Index
public class Question {

	@JsonIgnore
	@Id
	private String uuid;
	
	private String id;
	
	@Unindex
	private String title;
	
	@JsonIgnore
	private String slug;
	
	private String userId;
	
	@Serialize(zip=true)
	private List<Option> options;
	
	private long createdTime;
	
	private long modifiedTime;

	public Question(String surveyID, String question, int type, Set<Option> newOptionSet) {
		// TODO Auto-generated constructor stub
	}

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public long getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(long createdTime) {
		this.createdTime = createdTime;
	}

	public long getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(long modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public Object getQuestionType() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getQuestion() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
