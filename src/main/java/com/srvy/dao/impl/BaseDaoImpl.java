package com.srvy.dao.impl;

import java.util.List;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.srvy.dao.inf.BaseDao;

public abstract class BaseDaoImpl implements BaseDao {

	Result result = Result.NONE;
	
	public boolean isRecordFound(){
		return result == Result.RECORD_FOUND;
	}
	
	public boolean isRecordNotFound(){
		return result == Result.NO_RECORD_FOUND;
	}
	
	public boolean isWriteSuccess(){
		return result == Result.WRITE_SUCCESS;
	}
	
	public boolean isWriteFailure(){
		return result == Result.WRITE_FAILURE;
	}
	
	@Override
	public <T> List<T> writeBatch(List<T> models) {
		Objectify ofy = ObjectifyService.ofy();
		ofy.save().entities(models).now();
		ofy.flush();
		return models;
	}
	
	@Override
	public <T> T writeMO(T model) {
		Objectify ofy = ObjectifyService.ofy();
		ofy.save().entity(model).now();
		ofy.flush();
		return model;
	}
	
}
