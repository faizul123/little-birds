package com.srvy.helpers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.srvy.dao.inf.UserDao;
import com.srvy.exception.ValidationException;
import com.srvy.model.User;

/**
 * This helper util provies reusable methods <br/>
 * doesn't share any state between threads.
 * @author faizul
 *
 */
public class UserRestHelper {

	public User getLoginUser(HttpServletRequest request,UserDao dao){
		User user = null;
		try{
			String userID = getLoginUserID(request);
			user = dao.getUser(userID);			
		}catch(IllegalArgumentException e){
			
		}
		if(user == null) throw new ValidationException(401,"Please signin to access this information!");
		return user;		
	}
	
	public String getLoginUserID(HttpServletRequest request){
		HttpSession session = request.getSession();
		String userID = (String) session.getAttribute("userId");
		return userID;
	}
	
	public void clearSession(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.invalidate();
	}
	
}
