package com.srvy.rest;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.srvy.dao.DaoFactory;
import com.srvy.dao.inf.QuestionDao;
import com.srvy.dao.inf.SurveyDao;
import com.srvy.dao.inf.UserDao;
import com.srvy.helpers.UserRestHelper;
import com.srvy.model.Question;
import com.srvy.model.Survey;
import com.srvy.model.User;
import com.srvy.model.factory.ModelFactory;
import com.srvy.request.model.SurveyAnswerRequest;
import com.srvy.request.model.SurveyRequestWrapper;
import com.srvy.util.Response;
import com.srvy.util.ResponseBuilder;
import com.srvy.util.Utility;

@RestController
@RequestMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
public class SurveyService {

	
	@Autowired
	private DaoFactory daoFactory;
	
	@RequestMapping(value="/survey",method=RequestMethod.POST)
	public void createSurvey(HttpServletRequest request, @RequestBody SurveyRequestWrapper survey){
		
		ModelFactory modelFactory = new ModelFactory();
		
		UserRestHelper userRestHelper = new UserRestHelper();
		
		try {
		
			UserDao userDao = daoFactory.getDao(UserDao.class);
			
			User user = userRestHelper.getLoginUser(request, userDao);
			
			Survey surveyModel = modelFactory.newSurvey(survey.getSurvey(), user.getId());
			
			List<Question> questionsList = modelFactory.newQuestionList(survey.getQuestions(), surveyModel.getId());
			
			userDao.writeMO(surveyModel);
			
			userDao.writeBatch(questionsList);		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity<Object> deleteSurvey(@RequestBody List<SurveyRequestWrapper> surveys) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		ModelFactory modelFactory = new ModelFactory();
		for(SurveyRequestWrapper surveyreq : surveys ) {
		Survey survey = modelFactory.newSurvey(surveyreq.getSurvey(), "userId");////should get userId from session
	    List<Question> surveyQuestions = modelFactory.newQuestionList(surveyreq.getQuestions(), survey.getId());
	    
	    for(Question question : surveyQuestions) {
	    	daoFactory.getDao(QuestionDao.class).deleteQuestion(question.getId());
	    }
	    
		daoFactory.getDao(SurveyDao.class).deleteSurvey(survey);
		}
		return null;
	}

	@RequestMapping(value = "/mysurvey", method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> mySurveyList() {
		
		ResponseBuilder responseBuilder = Response.newBuilder();
		try {
			SurveyDao surveyDao = daoFactory.getDao(SurveyDao.class);
			QuestionDao questionDao = daoFactory.getDao(QuestionDao.class);
			
			List<Survey> surveys = surveyDao.viewMySurveyList(new User());
			
			int ct = 0;
			responseBuilder.add("survey count", surveys.size());
			for(Survey survey : surveys) {
			List<Question> questions = questionDao.getSurveyQuestions(survey.getId());
			
			if(questions != null) {
				Map<String,Object> surveyMap = new HashMap<>();
				 	
				surveyMap.put("title", survey.getTitle());
				surveyMap.put("Total Questions", survey.getTotalQuestions());
				
				for(Question question : questions) {
					Map<String,Object> questionMap = new HashMap<>();
					
					questionMap.put("type", question.getQuestionType());
					questionMap.put("question", question.getQuestion());
					questionMap.put("options", question.getOptions());
				
					surveyMap.put("question details", questionMap);
				}
				
				responseBuilder.add(String.valueOf(ct), surveyMap);
				ct++;
				
			}
			
			}
			
		} catch (Exception e) {

		}
		return responseBuilder.build();
	}
	
	
	@RequestMapping(value="/survey/answer", method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> saveSurveyAnswers(@RequestBody SurveyAnswerRequest answerRequest)
			throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, 
			InvocationTargetException, ValidationException{		 
		
		SurveyDao surveyDao = daoFactory.getDao(SurveyDao.class);
		String surveyId = answerRequest.getSurveyId();
		if(Utility.isNullOrEmpty(surveyId)){
			throw new ValidationException("surveyId couldn't empty or null");
		}
		surveyDao.getSurveyById(surveyId);
		if(surveyDao.isRecordNotFound()){
			throw new ValidationException("Invalid surveyId");
		}
		surveyDao.writeBatch(answerRequest.getAnswers());	
		if(surveyDao.isWriteSuccess()){
			return Response.newBuilder().add("message", "Successfully updated answers!").build();
		}else{
			return Response.newBuilder().add("message", "Couldn't save survey answer. Please try again!").build();
		}
	}
	
}
