package com.srvy.rest;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.srvy.dao.ObjectifyUtil;
import com.srvy.request.model.Credential;
import com.srvy.request.model.SignupInfo;


@RestController
@RequestMapping(consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
public class UserService {

	private final Logger log = Logger.getLogger("");
	
	private ObjectifyUtil ofyUtil;
	
	@RequestMapping(value="/signup",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String,Object>> signup(@RequestBody SignupInfo signupInfo){
		Map<String,Object> map = new HashMap<String,Object>();
		HttpStatus status = HttpStatus.OK;		
		map.put("message", "Successfully login");
		map.put("code", status.value());
		log.warning("username " + signupInfo.getEmailId());
		return new ResponseEntity<Map<String,Object>>(map,status);
	}
	
	
	@RequestMapping(value="/signin",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String,Object>> login(@RequestBody Credential credential){
		Map<String,Object> map = new HashMap<String,Object>();
		HttpStatus status = HttpStatus.OK;		
		map.put("message", "Successfully login");
		map.put("code", status.value());
		log.warning("username " + credential.getUsername());
		return new ResponseEntity<Map<String,Object>>(map,status);
	}
	
	
	
}
