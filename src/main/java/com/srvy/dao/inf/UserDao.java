package com.srvy.dao.inf;

import com.srvy.model.User;

public interface UserDao extends BaseDao {

	public User findUser(String username);
	
}
