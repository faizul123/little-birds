package com.srvy.rest;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.srvy.dao.DaoFactory;
import com.srvy.dao.inf.UserDao;
import com.srvy.exception.ServiceFailureException;
import com.srvy.exception.ValidationException;
import com.srvy.helpers.UserRestHelper;
import com.srvy.model.Profile;
import com.srvy.model.User;
import com.srvy.model.factory.ModelFactory;
import com.srvy.request.model.Credential;
import com.srvy.request.model.SignupInfo;
import com.srvy.util.AppConstants;
import com.srvy.util.Response;

@RestController
@RequestMapping(
value=AppConstants.ROOT_API,
consumes=MediaType.APPLICATION_JSON_VALUE,
produces=MediaType.APPLICATION_JSON_VALUE)
public class UserService {

	private final Logger log = Logger.getLogger("");
	
	@Autowired
	DaoFactory daoFactory;
	
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> signup(@RequestBody SignupInfo signupInfo) 
			
			throws ClassNotFoundException, NoSuchMethodException, 
			SecurityException, InstantiationException, 
			IllegalAccessException, IllegalArgumentException, 
			InvocationTargetException{
		
		
		UserDao userDao = daoFactory.getDao(UserDao.class);
		userDao.findUser(signupInfo.getEmailId());
		
		if(userDao.isRecordFound()){
			throw new ValidationException(400, "Account already exist!");
		}
		else{			
			ModelFactory moFactory = new ModelFactory(); // Used to construct model from the request object
						
			User user = moFactory.newUser(signupInfo);	// Building user model
					
			Profile profile = moFactory.newProfile(user, signupInfo); //Building profile model			
			
			List<Object> objects = new ArrayList<Object>();
			
			objects.add(user);
			objects.add(profile);
			userDao.writeBatch(objects);			// store into db
			
			if(userDao.isWriteSuccess()){		
			
				return Response.newBuilder()
						.add("message","Successfully your account has been created!")
						.add("code",HttpStatus.OK)
						.build();
			}else{
				throw new ServiceFailureException("");
			}
		}
	}
	
	
	@RequestMapping(value="/signin",method=RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> login(HttpServletRequest request,@RequestBody Credential credential) throws ClassNotFoundException, NoSuchMethodException, 
	SecurityException, InstantiationException, 
	IllegalAccessException, IllegalArgumentException, 
	InvocationTargetException{
		
		log.warning("dao " + daoFactory.toString());
		
		UserDao userDao = daoFactory.getDao(UserDao.class);
		
		User user = userDao.findUser(credential.getUsername());
		
		if(userDao.isRecordFound()){
			if(user.isPasswordMatch(credential)){				
				Profile profile = userDao.getProfile(user);				
				return Response
						.newBuilder()
							.add("message", "Hi " + profile.getName() + ", you have been successfully login!")
							.add("profile",profile)
						.newSession(request)
							.addAttribute("name", profile.getName())
							.addAttribute("username",profile.getEmailId())
							.addAttribute("userId", profile.getId())
							.done()
						.build();				
				
			}else{
				throw new ValidationException(400, "Password is wrong!");
			}
		}else{
			throw new ValidationException(400,"Username is wrong!");
		}
		
		
	}
	
	@RequestMapping(value="/profile/{identifier}",method=RequestMethod.GET,consumes=MediaType.ALL_VALUE)
	public ResponseEntity<Map<String,Object>> getProfile(HttpServletRequest request,@PathVariable("identifier") String identifier) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		UserDao userDao = daoFactory.getDao(UserDao.class);
		UserRestHelper helper = new UserRestHelper();
		if(identifier.equals("me")){			
			User user = helper.getLoginUser(request, userDao);
			Profile profile = userDao.getProfile(user);
			return Response.newBuilder().add("profile", profile).build();
		}else{
			User user = userDao.getUser(identifier);
			
			if(user == null){
				throw new ValidationException(400,"User not found!");
			}
			
			Profile profile = userDao.getProfile(user);
			return Response.newBuilder().add("profile", profile).build();
		}
	}
	
	@RequestMapping(value="/signout",method=RequestMethod.GET,consumes = MediaType.ALL_VALUE)
	public ResponseEntity<Map<String,Object>> signOut(HttpServletRequest request){
		new UserRestHelper().clearSession(request);
		return Response.newBuilder().add("message", "Signout successfully.!").build();
	}
	
	
	
	
}
