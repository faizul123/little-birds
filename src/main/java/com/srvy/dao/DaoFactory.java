package com.srvy.dao;

import java.util.Map;
import java.util.WeakHashMap;


public class DaoFactory {

	private Map<Class<?>,Object> daoMap = new WeakHashMap<Class<?>, Object>();
	
	public <T> T getDao(Class<T> clazz){
		if(daoMap.containsKey(clazz)){
			return clazz.cast(daoMap.get(clazz));	
		}
		return null;
	}
}