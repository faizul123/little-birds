package com.srvy.model.factory;

import java.util.LinkedHashSet;
import java.util.Set;

import com.srvy.model.Option;
import com.srvy.request.model.QuestionOptions;
import com.srvy.request.model.QuestionOptions.OptionType;

public class OptionBuilder {

	private QuestionOptions options;
	
	public OptionBuilder(QuestionOptions options){
		this.options = options;
	}
	
	public Set<Option> getOptions(){
		if(options.getOptionType() == OptionType.YES_NO){
			
		}
		return new LinkedHashSet<Option>();
	}
	
}
