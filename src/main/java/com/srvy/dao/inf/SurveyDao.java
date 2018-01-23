package com.srvy.dao.inf;

import java.util.List;

import com.srvy.model.Survey;
import com.srvy.model.User;

public interface SurveyDao extends BaseDao {


	/**
	 * 
	 * @param id
	 * @return
	 */
	public Survey getSurveyById(String id);
	
	public boolean createSurvey(Survey survey);
	
	public List<Survey> getSurveys(User user);
	
	public void deleteSurvey(Survey survey);
	
	public Survey viewSurveyDetails(Survey survey);
}
