package com.srvy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.googlecode.objectify.ObjectifyFilter;
import com.srvy.dao.DaoFactory;
import com.srvy.dao.ObjectifyUtil;
import com.srvy.helpers.UserRestHelper;
import com.srvy.model.factory.ModelFactory;

@Configuration
public class AppConfig {

	@Bean
	public DaoFactory daoFactory(){
		DaoFactory factory = new DaoFactory();
		factory.addDaoInfo("com.srvy.dao.inf.UserDao", "com.srvy.dao.impl.UserDaoImpl");
		factory.addDaoInfo("com.srvy.dao.inf.TopicDao", "com.srvy.dao.impl.TopicDaoImpl");		
		return factory;
	}
	
	@Bean
	public UserRestHelper userRestHelper(){
		return new UserRestHelper();
	}
	
	@Bean
	public ObjectifyUtil ofyUtil(){
		List<String> models = new ArrayList<String>();
		ObjectifyUtil ofyUtil = new ObjectifyUtil();
		models.add("com.srvy.model.User");
		models.add("com.srvy.model.Profile");
		models.add("com.srvy.model.Topic");
		models.add("com.srvy.model.UserTopics");
		ofyUtil.setModels(models);
		return ofyUtil;
	}
	
	/* Register filter for objectify */
	@Bean	
	public FilterRegistrationBean filterRegistrationBean(){
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.setFilter(new ObjectifyFilter());
		return bean;
	}
	
	@Bean
	public ModelFactory modelFactory(){
		return new ModelFactory();
	}
	
}
