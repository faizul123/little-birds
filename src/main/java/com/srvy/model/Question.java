package com.srvy.model;

import com.googlecode.objectify.annotation.Entity;

@Entity(name="Questions")
public class Question {

	private String uuid;
	
	private String id;
	
	private String title;
	
	private String slug;
	
	private long createdTime;
	
	private long modifiedTime;
	
}
