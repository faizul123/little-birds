package com.srvy.request.model;

public class QuestionDetails {
	
	private String question;
	private boolean isStartupQuestion;
	private String description;
	private int order;
	private QuestionOptions options;
	
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

	public QuestionOptions getOptions() {
		return options;
	}

	public void setOptions(QuestionOptions options) {
		this.options = options;
	}
}
