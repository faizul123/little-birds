package com.srvy.model;

import java.util.List;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;

@Entity(name="TargetAudiences")
@Index
public class TargetAudience {

	private String uuid;
	
	private String id;
	
	private int ageFrom;
	
	private int ageTo;
	
	private List<String> topicIds;
	
	private List<String> locations;
	
}
