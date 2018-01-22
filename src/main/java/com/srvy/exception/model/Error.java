package com.srvy.exception.model;

public class Error {
	
	private int code;
	
	private String message;
	
	private String description;
	
	private String moreInfo;
	
	public Error(int code,String msg,String desc,String info){
		this.code = code;
		message = msg;
		description = desc;
		moreInfo = info;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMoreInfo() {
		return moreInfo;
	}

	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}
	
}
