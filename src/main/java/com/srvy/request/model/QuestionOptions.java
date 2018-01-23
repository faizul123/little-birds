package com.srvy.request.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class QuestionOptions {
	
	public static enum OptionType {YES_NO,MULTI_OPTION,MULTI_CHECK,FEEDBACK,RANGE};
		
	private int type;
	
	private Map<String,Object> values;
	
	@JsonCreator
	public QuestionOptions(@JsonProperty("type") int type,@JsonProperty("values") Map<String,Object> map){
		this.type = type;
		this.values = map;
	}
	
	public int getType(){
		return type;
	}
	
	public Map<String,Object> getValues(){
		return values;
	}
	
	public OptionType getOptionType(){
		for(OptionType types : OptionType.values()){
			if(types.ordinal() == this.type){
				return types;
			}
		}
		return null;
	}
	
	public <T> T getValue(Class<T> klass,String key){
		if(values.containsKey(key)){
			Object object = values.get(key);
			if(object.getClass() == klass){
				return klass.cast(object);
			}
		}
		return null;
	}
}
