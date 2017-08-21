package com.srvy.model;

import java.util.concurrent.TimeUnit;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
@Index
public class Profile {

	@Id
	private String uuid;
	
	private String id;
	
	private String fistName;
	
	private String lastName;
	
	private long dob;
	
	private long age;
	
	public Profile() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Profile(String name ,long dob){
		updateName(name);
		updateAge(dob);
	}
	
	private void updateName(String name){
		String[] partOfName = name.split(" ");
		this.fistName = partOfName[0];
		this.lastName = partOfName[1];
	}
	
	private void updateAge(long dob){
		this.age = (dob - System.currentTimeMillis()) / (TimeUnit.MILLISECONDS.toDays(1000));
	}


	public String getFistName() {
		return fistName;
	}


	public void setFistName(String fistName) {
		this.fistName = fistName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public long getDob() {
		return dob;
	}


	public void setDob(long dob) {
		this.dob = dob;
	}


	public long getAge() {
		return age;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public void setAge(long age) {
		this.age = age;
	}
	
	
	
}
