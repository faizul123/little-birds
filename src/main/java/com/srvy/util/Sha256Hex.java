package com.srvy.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

import javax.xml.bind.DatatypeConverter;

public class Sha256Hex {

	private MessageDigest digest ;
	
	public Sha256Hex(){
		try {
			digest = MessageDigest.getInstance("Sha-256");
		} catch (NoSuchAlgorithmException e) {
			Logger.getLogger("").warning(e.toString());
		}
	}
	
	public String doHash(String data){
		String hashed = "";
		try {
			byte[] bytes = digest.digest(data.getBytes("UTF-8"));
			hashed = DatatypeConverter.printHexBinary(bytes);
		} catch (UnsupportedEncodingException e) {
			Utility.printLog(e);
		}
		return hashed;
	}
	
}
