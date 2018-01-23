package com.srvy.rest;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

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
	
	@Autowired
	private UserRestHelper userRestHelper;
	
	@Autowired
	private ModelFactory modelFactory;
	
	@RequestMapping(value="/survey",method=RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> createSurvey(HttpServletRequest request, @RequestBody SurveyRequestWrapper survey){
		
		try {
		
			UserDao userDao = daoFactory.getDao(UserDao.class);
			
			User user = userRestHelper.getLoginUser(request, userDao);
			
			Survey surveyModel = modelFactory.newSurvey(survey.getSurvey(), user.getId());
			
			List<Question> questionsList = modelFactory.newQuestionList(survey.getQuestions(), surveyModel.getId());
			
			userDao.writeMO(surveyModel);
			
			userDao.writeBatch(questionsList);		
			
			return Response.newBuilder().add("message", "Successfully survey created").add("code", 200).build();
			
		} catch (Exception e) {
			Logger.getLogger("").warning("err " + e.toString());
			e.printStackTrace();
		}
		
		return Response.newBuilder().add("message", "Couldn't save to survey").build();
		
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

	@RequestMapping(value = "/mysurveys", method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> mySurveyList(HttpServletRequest request) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		ResponseBuilder responseBuilder = Response.newBuilder();
		
			User user = userRestHelper.getLoginUser(request, daoFactory.getDao(UserDao.class));
			
			SurveyDao surveyDao = daoFactory.getDao(SurveyDao.class);			
			
			List<Survey> surveys = surveyDao.getSurveys(user);			 
			responseBuilder.add("total", surveys.size());			
			responseBuilder.add("surveys", surveys);			
		
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
