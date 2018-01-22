package com.srvy.request.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SurveyRequestWrapper {

	private SurveyDetails survey;
	private List<QuestionDetails> questions;
	
	@JsonProperty(required=false)
	private List<FilterDetails> filters;
	
	public List<QuestionDetails> getQuestions() {
		return questions;
	}
	
	public List<FilterDetails> getFilters() {
		return filters;
	}
	
	public SurveyDetails getSurvey() {
		return survey;
	}

	public void setSurvey(SurveyDetails survey) {
		this.survey = survey;
	}

	public void setQuestions(List<QuestionDetails> questions) {
		this.questions = questions;
	}

	public void setFilters(List<FilterDetails> filters) {
		this.filters = filters;
	}
	
}
