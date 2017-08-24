package com.srvy.util;

public interface Condition {

	void and();
	
	void or();
	
	void If();
	
	void itr();
	
	void filter(Object object,int index);
	
	void recursive();
}
