package com.srvy.dao.inf;

import java.util.List;

import com.srvy.model.Question;

public interface QuestionDao {

	public boolean createQuestions(List<Question> questions);
	
	public List<Question> getSurveyQuestions(String surveyID);
	
	public void deleteQuestion(String questionID);
}
