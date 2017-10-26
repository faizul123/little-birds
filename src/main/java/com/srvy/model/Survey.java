package com.srvy.model;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Load;
import com.googlecode.objectify.annotation.Unindex;

@Entity(name="Surveys")
@Index
public class Survey {
	
	@Id
	private String uuid;
	
	private String id;
	
	@Unindex
	private String title;
	
	private String slug;
	
	@Unindex
	private String description;
	
	private int totalQuestions;
	
	private int points;
	
	private long createdTime;
	
	private long modifiedTime;
	
	private boolean isPublic;
	
	private String createdBy;
	
	@Load()
	private Ref<TargetAudience> targetAudience;
	
}
