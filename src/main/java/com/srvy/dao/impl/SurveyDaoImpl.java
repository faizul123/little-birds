package com.srvy.dao.impl;

import java.util.List;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.srvy.dao.inf.SurveyDao;
import com.srvy.model.Survey;
import com.srvy.model.User;

public class SurveyDaoImpl extends BaseDaoImpl implements SurveyDao {

	
	private Objectify ofy;
	
	public SurveyDaoImpl(Objectify ofy){
		this.ofy = ofy;
	}

	@Override
	public Survey getSurveyById(String id) {
		Key<Survey> surveyKey = Key.create(Survey.class,id);
		Survey survey = ofy.load().type(Survey.class).filterKey(surveyKey).first().now();		
		return updateResult(survey);		
	} 
	
	
	@Override
	public boolean createSurvey(Survey survey) {
		writeBatch(survey);
		return isWriteSuccess();
	}

	@Override
	public List<Survey> viewMySurveyList(User user) {
		
		return ofy.load().type(Survey.class).filterKey("userId", user.getId()).list();
	}

	@Override
	public void deleteSurvey(Survey survey) {
		Key<Survey> surveyKey = Key.create(Survey.class,survey.getId());
		ofy.delete().key(surveyKey).now();
	}

	@Override
	public Survey viewSurveyDetails(Survey survey) {
		// TODO Auto-generated method stub
		return null;
	}
}
