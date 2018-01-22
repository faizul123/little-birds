package com.srvy.dao.impl;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.srvy.dao.inf.BaseDao;

public abstract class BaseDaoImpl implements BaseDao {

	Result result = Result.NONE;
	
	Logger log = Logger.getLogger("");
	
	public boolean isRecordFound(){
		return result == Result.RECORD_FOUND;
	}
	
	public boolean isRecordNotFound(){
		return result == Result.NO_RECORD_FOUND;
	}
	
	public boolean isWriteSuccess(){
		log.warning("DB Ops : "+ result);
		return result == Result.WRITE_SUCCESS;
	}
	
	public boolean isWriteFailure(){
		return result == Result.WRITE_FAILURE;
	}
	
	public void reset(){
		result = Result.NONE;
	}
	
	public <T> T updateResult(T object){
		result = (object == null ? Result.NO_RECORD_FOUND : Result.RECORD_FOUND );
		return object;
	}
	
	public <T> List<T> updateResult(List<T> objects){
		result = (objects == null ? Result.NO_RECORD_FOUND : Result.RECORD_FOUND );
		return objects;
	}
	
	public void writeFailure(){
		result = Result.WRITE_FAILURE;
	}
	
	public void writeSuccess(){
		result = Result.WRITE_SUCCESS;
	}
	
	@Override
	public <T> List<T> writeBatch(List<T> models) {
		try{
			Objectify ofy = ObjectifyService.ofy();
			ofy.save().entities(models).now();
			ofy.flush();
			result = Result.WRITE_SUCCESS;
			return models;
		}catch(Exception e){
			log.warning(e.toString());
			result = Result.WRITE_FAILURE;
		}
		return Collections.emptyList();
	}
	
	 @Override
	public void writeBatch(Object...t) {
		try{
			Objectify ofy = ObjectifyService.ofy();
			ofy.save().entities(t).now();
			ofy.flush();
			result = Result.WRITE_SUCCESS;
		}catch(Exception e){
			log.warning(e.toString());
			result = Result.WRITE_FAILURE;
		}
	}
	
	@Override
	public <T> T writeMO(T model) {
		try{
			//List<Object> list = new ArrayList<Object>();
			Objectify ofy = ObjectifyService.ofy();
			ofy.save().entity(model).now();
			ofy.flush();
			result = Result.WRITE_SUCCESS;
			return model;
		}catch(Exception e){
			result = Result.WRITE_FAILURE;
		}
		return null;
	}
	
}
