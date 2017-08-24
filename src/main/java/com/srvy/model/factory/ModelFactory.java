package com.srvy.model.factory;

import com.srvy.model.Profile;
import com.srvy.model.User;
import com.srvy.request.model.SignupInfo;

public class ModelFactory {

	
	public User newUser(SignupInfo info){
	
		User user = new User(info);
		
		return user;
	}
	
	public Profile newProfile(SignupInfo info){
		return null;
	}
	
}
