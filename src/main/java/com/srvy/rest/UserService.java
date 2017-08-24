package com.srvy.rest;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.srvy.dao.DaoFactory;
import com.srvy.dao.inf.UserDao;
import com.srvy.exception.ValidationException;
import com.srvy.model.User;
import com.srvy.model.factory.ModelFactory;
import com.srvy.request.model.Credential;
import com.srvy.request.model.SignupInfo;


@RestController
@RequestMapping(consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
public class UserService {

	private final Logger log = Logger.getLogger("");
	
	@Autowired
	DaoFactory daoFactory;
	
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> signup(@RequestBody SignupInfo signupInfo) 
			throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		UserDao userDao = daoFactory.getDao(UserDao.class);
		userDao.findUser(signupInfo.getEmailId());
		if(userDao.isRecordFound()){
			throw new ValidationException(400, "Account already exist!");
		}
		else{
			ModelFactory moFactory = new ModelFactory();
			User user = moFactory.newUser(signupInfo);
			userDao.writeMO(user);
		}
		Map<String,Object> map = new HashMap<String,Object>();
		HttpStatus status = HttpStatus.OK;		
		map.put("message", "Successfully login");
		map.put("code", status.value());
		log.warning("username " + signupInfo.getEmailId());
		return new ResponseEntity<Map<String,Object>>(map,status);
	}
	
	
	@RequestMapping(value="/signin",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String,Object>> login(@RequestBody Credential credential) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		log.warning("dao " + daoFactory.toString());
		UserDao userDao = daoFactory.getDao(UserDao.class);
		userDao.findUser("");
		Map<String,Object> map = new HashMap<String,Object>();
		HttpStatus status = HttpStatus.OK;		
		map.put("message", "Successfully login");
		map.put("code", status.value());
		log.warning("username " + credential.getUsername());
		return new ResponseEntity<Map<String,Object>>(map,status);
	}
	
	
	
}
