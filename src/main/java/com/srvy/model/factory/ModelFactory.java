package com.srvy.model.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.srvy.exception.ValidationException;
import com.srvy.model.Profile;
import com.srvy.model.Topic;
import com.srvy.model.User;
import com.srvy.model.UserTopics;
import com.srvy.request.model.SignupInfo;
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
	
}
