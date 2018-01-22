package com.srvy.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.srvy.util.Utility;

@Entity()
@Index
public class UserTopics {

	@Id
	private String uuid;
	
	private String id;
	
	private String userId;
	
	private String topicId;
	
	private long createdTime;
	
	private long modifiedTime;
	
	public UserTopics(String userId,String topicId){
		this.userId = userId;
		this.topicId = topicId;
		this.id = Utility.randomUUID();
		this.uuid = this.id;
		this.createdTime = System.currentTimeMillis();
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
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
	
	
	
}
