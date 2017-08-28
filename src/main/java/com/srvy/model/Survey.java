package com.srvy.model;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Load;

@Entity(name="Surveys")
@Index
public class Survey {

	private String uuid;
	
	private String id;
	
	private String title;
	
	private String slug;
	
	private String description;
	
	private int totalQuestions;
	
	private int points;
	
	private boolean isDraft;
	
	private String planId;
	
	private long createdTime;
	
	private long modifiedTime;
	
	private String createdBy;
	
	@Load()
	private Ref<TargetAudience> targetAudience;
	
}
