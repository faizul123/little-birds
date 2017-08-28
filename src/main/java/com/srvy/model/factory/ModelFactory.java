package com.srvy.model.factory;

import java.util.Map;

import com.srvy.exception.ValidationException;
import com.srvy.model.Profile;
import com.srvy.model.Topic;
import com.srvy.model.User;
import com.srvy.request.model.SignupInfo;

public class ModelFactory {

	
	public User newUser(SignupInfo info){
	
		User user = new User(info);
		
		return user;
	}
	
	public Profile newProfile(User user,SignupInfo info){		
		return new Profile(user, info);
	}

	public Topic newTopic(Map<String,Object> map){
		
		if(map.containsKey("title")){
			String title = (String) map.get("title");
			Topic topic = new Topic(title);
			return topic;
		}else{
			throw new ValidationException(400, "title is missing");
		}
	}
	
}
