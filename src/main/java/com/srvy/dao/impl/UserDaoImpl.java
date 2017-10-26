package com.srvy.dao.impl;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.srvy.dao.inf.UserDao;
import com.srvy.model.Profile;
import com.srvy.model.User;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	private Objectify ofy;
	
	public UserDaoImpl(Objectify ofy) {
		this.ofy = ofy;
	}

	@Override
	public User findUser(String username) {
		User user = ofy.load().type(User.class).filter("username", username).first().now();
		result = (user == null ? Result.NO_RECORD_FOUND : Result.RECORD_FOUND);
		return user;
	}
	
	public User getUser(String userId){
		Key<User> userKey = Key.create(User.class, userId);
		User user = ofy.load().key(userKey).now();
		result = (user == null ? Result.NO_RECORD_FOUND : Result.RECORD_FOUND);
		return user;
	}

	@Override
	public Profile getProfile(User user) {
		Key<Profile> profileKey = Key.create(Profile.class,user.getId());
		Profile profile = ofy.load().key(profileKey).now();
		result = (profile == null) ? Result.NO_RECORD_FOUND : Result.RECORD_FOUND;
		return profile;
	}
	
}
