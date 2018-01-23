package com.srvy.model.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import com.srvy.exception.ValidationException;
import com.srvy.model.Filters;
import com.srvy.model.Option;
import com.srvy.model.Profile;
import com.srvy.model.Question;
import com.srvy.model.Survey;
import com.srvy.model.Topic;
import com.srvy.model.User;
import com.srvy.model.UserTopics;
import com.srvy.request.model.FilterDetails;
import com.srvy.request.model.QuestionDetails;
import com.srvy.request.model.QuestionOptions;
import com.srvy.request.model.SignupInfo;
import com.srvy.request.model.SurveyDetails;
import com.srvy.request.model.TopicInfo;
import com.srvy.util.Utility;

/**
 * Centralized Factory for creating Model object<br/>
 * for to store in persistent storage.<br/>
 * Its thread safe, clean and simple<br/>
 * @author faizul
 *
 */
public class ModelFactory {

	Logger log = Logger.getLogger("");
	
	public User newUser(SignupInfo info){
	
		User user = new User(info);
		
		return user;
	}
	
	public Profile newProfile(User user,SignupInfo info){		
		return new Profile(user, info);
	}

	public Topic newTopic(TopicInfo topicInfo){
		if(Utility.isNullOrEmpty(topicInfo.getTitle()))
			throw new ValidationException(400, "title is missing!");
		log.warning(""+topicInfo);
		Topic topic = new Topic(topicInfo.getTitle());
		return topic;		
	}
	
	public List<UserTopics> createUserTopics(User user,List<TopicInfo> topicInfoList){
		List<UserTopics> topics = new ArrayList<UserTopics>();
		for(TopicInfo topic : topicInfoList){
			topics.add(new UserTopics(user.getId(), topic.getId()));
		}
		return topics;
	}
	

	public Survey newSurvey(SurveyDetails surveyDetails, String userId) {
		
		Survey survey = new Survey(surveyDetails.getTitle(), surveyDetails.getTotalQuestions(),userId);
		survey.setCreditabilityQuestionPresent(surveyDetails.isCreditabilityQuestionPresent());
		return survey;
		
	}
	
	public Question newQuestion(QuestionDetails questionDetails, String surveyID) {
		
		Question question = new Question(surveyID, questionDetails.getQuestion(), 
				questionDetails.getOptions().getType(),newOptionSet(questionDetails.getOptions()));
		return question;
	}
	
	public List<Question> newQuestionList(List<QuestionDetails> questionDetailsList,String surveyID){
		List<Question> questionsList = new ArrayList<>();
		
		for(QuestionDetails quesDetails : questionDetailsList)
			questionsList.add(newQuestion(quesDetails, surveyID));
			
		return questionsList;
	}
	
	public Filters newFilter(FilterDetails filterDetails, String surveyID) {
		
		return new Filters(filterDetails.getFilterName(), filterDetails.getFilterVal(), filterDetails.getFilterType(), surveyID);
	}
	
	public Set<Option> newOptionSet(QuestionOptions options) {
		OptionBuilder optBuilder = new OptionBuilder(options);
		return optBuilder.getOptions();
	}
		
}
