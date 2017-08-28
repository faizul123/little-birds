package com.srvy.dao.inf;

import java.util.List;

public interface BaseDao {
	
	enum Result{
		NO_RECORD_FOUND,
		RECORD_FOUND,
		WRITE_SUCCESS,
		WRITE_FAILURE,
		TOO_MANY_RECORDS,
		NONE
	}
	
	<T> List<T> writeBatch(List<T> models);
	
	<T> void writeBatch(Object...t);
	
	<T> T writeMO(T model);
	
	public boolean isRecordFound();
	
	public boolean isRecordNotFound();
	
	public boolean isWriteSuccess();
	
	public boolean isWriteFailure();
	
	public void reset();
	
}
