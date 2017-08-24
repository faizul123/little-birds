package com.srvy.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;


public class DaoFactory {

	// To hold interface and Impl 
	private Map<String,String> daoMap = new ConcurrentHashMap<String,String>();
	
	public DaoFactory() {
		Logger.getLogger("").warning("Initializing DaoFactory...");
	}
	
	public <T> T getDao(Class<T> clazz) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		 
		if(daoMap.containsKey(clazz.getCanonicalName())){
			Class<?> daoImpl = Class.forName(daoMap.get(clazz.getCanonicalName()));
			return clazz.cast(daoImpl.getConstructor(Objectify.class).newInstance(ObjectifyService.ofy()));	
		}
		return null;
	}

	public Map<String, String> getDaoMap() {
		return daoMap;
	}

	public void setDaoMap(Map<String, String> daoMap) {
		this.daoMap = daoMap;
	}
}