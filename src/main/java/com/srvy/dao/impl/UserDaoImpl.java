package com.srvy.dao.impl;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.srvy.dao.ObjectifyUtil;
import com.srvy.dao.inf.UserDao;
import com.srvy.model.User;

public class UserDaoImpl implements UserDao {

	private Objectify ofy;
	
	public UserDaoImpl(ObjectifyUtil ofyUtil) {
		this.ofy = ofyUtil.getObjectify();
	}

	@Override
	public User findUser(String username) {
		Key<User> userKey = Key.create(User.class, username);
		return ofy.load().key(userKey).now();
	}
	
}
