package com.srvy.rest.inf;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.srvy.request.model.TopicInfo;

public interface TopicsInterface {

	/**
	 * Create new topic for user to subscribe and post the survey under <br/>
	 * the topic.
	 * 	
	 * @param topicInfo
	 * @return
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	@RequestMapping(value="/topic",method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> newTopic(TopicInfo topicInfo) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;

	/**
	 * List all the topics
	 * @param page
	 * @param limit
	 * @return
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	@RequestMapping(value="/topics",method=RequestMethod.GET,consumes=MediaType.ALL_VALUE)
	public ResponseEntity<Map<String,Object>> getTopics(int page,int limit) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
}
