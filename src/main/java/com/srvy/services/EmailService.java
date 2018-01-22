package com.srvy.services;

import com.srvy.model.Email;

public interface EmailService {

	public void addEmail(Email email);
	
	public void removeEmail(Email email);
	
	public void send();
}
