package com.srvy.dao.impl;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.srvy.dao.inf.UserDao;
import com.srvy.model.User;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	private Objectify ofy;
	
	public UserDaoImpl(Objectify ofy) {
		this.ofy = ofy;
	}

	@Override
	public User findUser(String username) {
		Key<User> userKey = Key.create(User.class, username);
		User user = ofy.load().key(userKey).now();
		result = (user == null ? Result.NO_RECORD_FOUND : Result.RECORD_FOUND);
		return user;
	}
	
}
