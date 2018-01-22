package com.srvy.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Load;
import com.googlecode.objectify.annotation.Unindex;
import com.srvy.util.Utility;

@Entity(name="Surveys")
@Index
public class Survey {
	
	
	@JsonIgnore
	@Id
	private String uuid;
	
	private String id;
	
	@Unindex
	private String title;
	
	private String slug;
	
	@Unindex
	private String description;
	
	private int totalQuestions;
	
	private long createdTime;
	
	private long modifiedTime;
	
	private boolean isPublic;
	
	private boolean isCreditabilityQuestionPresent;
	
	private String createdBy;
	
	private List<Key<Question>> questionKeys;
	
	@Load()
	private Ref<TargetAudience> targetAudience;

	public Survey(String title2, int totalQuestions2, String userId) {
		id = Utility.randomUUID();
		setTitle(title2);
		setTotalQuestions(totalQuestions2);
		setCreatedBy(userId);
		setDefaultValues();
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
		updateSlug();
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTotalQuestions() {
		return totalQuestions;
	}

	public void setTotalQuestions(int totalQuestions) {
		this.totalQuestions = totalQuestions;
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

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Ref<TargetAudience> getTargetAudience() {
		return targetAudience;
	}

	public void setTargetAudience(Ref<TargetAudience> targetAudience) {
		this.targetAudience = targetAudience;
	}

	public boolean isCreditabilityQuestionPresent() {
		return isCreditabilityQuestionPresent;
	}

	public void setCreditabilityQuestionPresent(boolean isCreditabilityQuestionPresent) {
		this.isCreditabilityQuestionPresent = isCreditabilityQuestionPresent;
	}

	private void setDefaultValues(){
		createdTime = System.currentTimeMillis();
		isPublic = true;
	}
	
	private void updateSlug() {
		this.slug = Utility.toSlug(this.title);
	}

	public List<Key<Question>> getQuestionKeys() {
		return questionKeys;
	}

	public void setQuestionKeys(List<Key<Question>> questionKeys) {
		this.questionKeys = questionKeys;
	}
	
}
