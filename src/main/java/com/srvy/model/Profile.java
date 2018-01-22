package com.srvy.model;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.srvy.request.model.SignupInfo;

@Entity
@Index
public class Profile {

	@Id
	private String uuid;
	
	private String id;
	
	private String emailId;
	
	private String fistName;
	
	private String lastName;
	
	private long dob;
	
	private long age;
	
	private String aboutMe;
	
	private String imageURL;
	
	private String location;
	
	private String qualification;
	
	private Ref<Plan> plan;
	
	public Profile() {
		
	}
	
	public Profile(User user,SignupInfo info){
		updateName(info.getName());
		setAge(info.getAge());
		setDob(info.getDob());
		setLocation(info.getLocation());
		setQualification(info.getQualification());
		setEmailId(info.getEmailId());
		id = user.getId();
		uuid = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public Ref<Plan> getPlan() {
		return plan;
	}

	public void setPlan(Ref<Plan> plan) {
		this.plan = plan;
	}
	
	private void updateName(String name){
		String[] partOfName = name.split(" ");
		this.fistName = partOfName[0];
		this.lastName = partOfName[1];
	}

	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
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

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getName(){
		return this.fistName + " " + this.lastName;
	}
	
}
