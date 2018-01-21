package com.srvy.backend.backend.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloService {

	@RequestMapping(value="/")
	public String hello(){
		return "Hello spring";
	}
	
}
