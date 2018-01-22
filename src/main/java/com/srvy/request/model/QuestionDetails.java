package com.srvy.request.model;

import java.util.Set;

public class QuestionDetails {
	
	private String question;
	private boolean isStartupQuestion;
	private String description;
	private int order;
	private Set<String> choices;
	private int type;
	
	public static enum OptionType {SINGLE_SELECT, MULTI_SELECT, RANGE, TEXT,RATING };

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Set<String> getChoices() {
		return choices;
	}

	public void setChoices(Set<String> choices) {
		this.choices = choices;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public boolean isSpecialQuestion() {
		return isStartupQuestion;
	}

	public void setSpecialQuestion(boolean isSpecialQuestion) {
		this.isStartupQuestion = isSpecialQuestion;
	}

	public String getHint() {
		return description;
	}

	public void setHint(String hint) {
		this.description = hint;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
}
