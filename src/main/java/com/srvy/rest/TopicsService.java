package com.srvy.rest;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.appengine.repackaged.com.google.io.protocol.HtmlFormGenerator.Constants;
import com.srvy.dao.DaoFactory;
import com.srvy.dao.inf.TopicDao;
import com.srvy.exception.ServiceFailureException;
import com.srvy.exception.ValidationException;
import com.srvy.model.Topic;
import com.srvy.model.factory.ModelFactory;
import com.srvy.request.model.TopicInfo;
import com.srvy.rest.inf.TopicsInterface;
import com.srvy.util.AppConstants;
import com.srvy.util.Response;
import com.srvy.util.Utility;

@RestController
@RequestMapping(value=AppConstants.ROOT_API,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
public class TopicsService implements TopicsInterface {

	@Autowired
	DaoFactory daoFactory;

	@Override
	public ResponseEntity<Map<String, Object>> newTopic(@RequestBody TopicInfo topicInfo) 
			throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		TopicDao topicDao = daoFactory.getDao(TopicDao.class); 
		ModelFactory moFactory = new ModelFactory();
		Topic topic = moFactory.newTopic(topicInfo);
		topicDao.getTopic(topic.getSlug(), false);
		if(topicDao.isRecordFound()){
			throw new ValidationException(400, "Already exist");
		}else{
			topicDao.writeMO(topic);
			if(topicDao.isWriteSuccess()){
				return Response.newBuilder().add("topic",topic).build();
			}else{
				throw new ServiceFailureException("Service failure");
			}
		}
		
	}

	@Override
	public ResponseEntity<Map<String, Object>> getTopics(int page, int limit) 
			throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		TopicDao topicDao = daoFactory.getDao(TopicDao.class);
		int offset = Utility.getOffSet(page, limit);
		List<Topic> topics = topicDao.getTopics(page, offset);
		return Response.newBuilder().add("topics", topics).add("page", page).add("limit", limit).build();		
	}
	
	
}
