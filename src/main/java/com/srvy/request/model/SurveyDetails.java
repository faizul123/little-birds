package com.srvy.request.model;

public class SurveyDetails {
	
	private String title;
	
	private int totalQuestions;
	
	private String description;
	
	private boolean isCreditabilityQuestionPresent;

	public int getTotalQuestions() {
		return totalQuestions;
	}

	public void setTotalQuestions(int totalQuestions) {
		this.totalQuestions = totalQuestions;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isCreditabilityQuestionPresent() {
		return isCreditabilityQuestionPresent;
	}

	public void setCreditabilityQuestionPresent(boolean isCreditabilityQuestionPresent) {
		this.isCreditabilityQuestionPresent = isCreditabilityQuestionPresent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
