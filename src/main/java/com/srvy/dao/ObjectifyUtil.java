package com.srvy.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class ObjectifyUtil implements InitializingBean {

	List<String> models = new ArrayList<String>();
	
	@Override
	public void afterPropertiesSet() throws ClassNotFoundException{
		for(String model : models){
			Class<?> clazz = Class.forName(model);
			ObjectifyService.register(clazz);
		}		
	}
	
	public Objectify getObjectify(){
		return ObjectifyService.ofy();
	}

	public List<String> getModels() {
		return models;
	}

	public void setModels(List<String> models) {
		this.models = models;
	}
	
}
