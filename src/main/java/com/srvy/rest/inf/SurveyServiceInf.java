package com.srvy.rest.inf;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface SurveyServiceInf {

	@RequestMapping(value="/survey",method=RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> newSurvey();
	
	@RequestMapping(value="/surveys",method=RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> getSurveys();
	
}
