package com.srvy.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.InitializingBean;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class ObjectifyUtil implements InitializingBean {

	List<String> models = new ArrayList<String>();
	
	@Override
	public void afterPropertiesSet() throws ClassNotFoundException{
		long start = System.currentTimeMillis(),end=0;
		Logger.getLogger("").warning("Model scanning started...");
		for(String model : models){
			Class<?> clazz = Class.forName(model);
			ObjectifyService.register(clazz);
		}
		end = System.currentTimeMillis();
		Logger.getLogger("").warning("Model scanning completed ... " + (end-start) + " in ms");
		Logger.getLogger("").warning("Total models : " + models.size());
		Logger.getLogger("").warning("models : " + models);
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
