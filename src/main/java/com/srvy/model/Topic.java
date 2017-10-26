package com.srvy.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Unindex;
import com.srvy.util.Utility;


@Entity(name="Topics")
@Index
public class Topic {

	@Id
	private String uuid;
	
	private String id;
	
	@Unindex
	private String title;
	
	private String slug;
	
	private long subscribeCount;
	
	private long createdTime;
	
	private long modifiedTime;
	
	//private String trackId;
	
	private long hotRate = 1;
	
	public Topic() {
		
	}
	
	public Topic(String title){
		this.title = title;
		this.slug = Utility.toSlug(title);
		this.id = Utility.randomUUID();
		this.uuid = this.id;
		this.createdTime = System.currentTimeMillis();
	}
	
	public Topic(String title,String slug){
		this.title = title;
		this.slug = slug;
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

	public long getSubscribeCount() {
		return subscribeCount;
	}

	public void setSubscribeCount(long subscribeCount) {
		this.subscribeCount = subscribeCount;
	}
	
	public void incrementSubscribeCount(){
		this.subscribeCount ++;
		this.modifiedTime = System.currentTimeMillis();
	}
	
	public void decrementSubscribeCount(){
		this.subscribeCount --;
		this.modifiedTime = System.currentTimeMillis();
	}
	
	public long getHotRate() {
		return hotRate;
	}

	public void setHotRate(long hotRate) {
		this.hotRate = hotRate;
	}

	public String toString(){
		return "<Topic title = " + title + ""
				+ " slug = " + slug + ""
				+ " subscribeCount = " + subscribeCount + ""
				+ " createdTime = " + createdTime + ""
				+ " modifiedTime = " + modifiedTime + " />";
	}
	
}
