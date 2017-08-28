package com.srvy.dao.inf;

import com.srvy.model.Profile;
import com.srvy.model.User;


/**
 * This interface provides list of possibilities of User kind <br/>
 * Operations and queries.
 * @author Faizul
 *
 */
public interface UserDao extends BaseDao {

	/**
	 * It returns a record of matched {@code username} <br/>
	 * in the database.
	 *  
	 * @author Faizul
	 * @param username User's unique reference
	 * @return
	 */
	public User findUser(String username);
	
	public Profile getProfile(User user);
	
}
