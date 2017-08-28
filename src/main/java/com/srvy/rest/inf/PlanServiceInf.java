package com.srvy.rest.inf;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface PlanServiceInf {

	@RequestMapping(value="/plan",method=RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> newPlan();
	
	@RequestMapping(value="/plans",method=RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> getPlans(int page,int limit);
	
}
