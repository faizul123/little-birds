package com.srvy.request.model;

import java.util.List;

import com.srvy.model.Answer;

public class SurveyAnswerRequest {

	private String surveyId;
	
	private String userId;
	
	private List<Answer> answers;

	public String getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(String surveyId) {
		this.surveyId = surveyId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
}
