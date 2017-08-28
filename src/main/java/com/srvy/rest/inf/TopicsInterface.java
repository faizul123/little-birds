package com.srvy.rest.inf;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface TopicsInterface {

	@RequestMapping(value="/topic",method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> newTopic(Map<String,Object> topic) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;

	@RequestMapping(value="/topics",method=RequestMethod.GET,consumes=MediaType.ALL_VALUE)
	public ResponseEntity<Map<String,Object>> getTopics(int page,int limit) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
}
