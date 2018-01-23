package com.srvy.model.factory;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.srvy.model.Option;
import com.srvy.request.model.QuestionOptions;

public class OptionBuilder {

	private QuestionOptions options;
	
	private final String MULTI_OPTION_KEY = "options";
	
	private final String FEEDBACK_KEY = "feedback";
	
	private final String MULTI_CHECK_KEY = "multicheck";
	
	public OptionBuilder(QuestionOptions options){
		this.options = options;
	}
	
	public Set<Option> getOptions(){
		switch(options.getOptionType()){
			case YES_NO : return yesNoOption();
			case MULTI_OPTION : return multiOptions();
			case FEEDBACK: return feedback();
			case MULTI_CHECK: return multiCheck();
			case RANGE: return range();				
			default:
				break;	
		}
		return new LinkedHashSet<Option>();
	}
	
	private Set<Option> yesNoOption(){
		Option yes = new Option("Yes",options.getType());
		Option no = new Option("No",options.getType());
		Set<Option> sets = new LinkedHashSet<Option>();
		sets.add(yes);
		sets.add(no);
		return sets;
	}
	
	private Set<Option> multiOptions(){
		List<String> list = options.getValue(List.class, MULTI_OPTION_KEY);
		return list.stream().map(s -> new Option(s,options.getType())).collect(Collectors.toSet());		
	}
	
	private Set<Option> feedback(){
		return Stream.of(new Option(FEEDBACK_KEY,options.getType())).collect(Collectors.toSet());
	}
	
	private Set<Option> multiCheck(){
		List<String> list = options.getValue(List.class, MULTI_CHECK_KEY);
		return list.stream().map(v -> new Option(v,options.getType())).collect(Collectors.toSet());
	}
	
	/** Sukumar's Gift */
	private Set<Option> range(){
		Integer start = options.getValue(Integer.class, "start");
		Integer end = options.getValue(Integer.class, "end");
		return Stream.of(start,end).map(i -> new Option(String.valueOf(i),options.getType())).collect(Collectors.toSet());
	}
	
}
