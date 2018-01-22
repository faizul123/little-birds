package com.srvy.model;

import com.googlecode.objectify.annotation.Entity;

@Entity(name = "Filters")
public class Filters {
	
	private String filterName, filterVal, filterType, surveyID;

	public Filters(String filterName, String filterVal, String filterType, String surveyID) {
		this.filterName = filterName;
		this.filterVal = filterVal;
		this.filterType = filterType;
		this.surveyID = surveyID;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

	public String getFilterVal() {
		return filterVal;
	}

	public void setFilterVal(String filterVal) {
		this.filterVal = filterVal;
	}

	public String getFilterType() {
		return filterType;
	}

	public void setFilterType(String filterType) {
		this.filterType = filterType;
	}

	public String getSurveyID() {
		return surveyID;
	}

	public void setSurveyID(String surveyID) {
		this.surveyID = surveyID;
	}

}
