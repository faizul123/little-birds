package com.srvy.request.model;

public class FilterDetails {

	private String filterVal, filterType, filterName;
	
	public static enum FilterType {SINGLE_VAL, MULTI_VAL, RANGE };
	
	public static enum SurveyFilters {AGE, GENDER, LOCATION};

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

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}
	
}
