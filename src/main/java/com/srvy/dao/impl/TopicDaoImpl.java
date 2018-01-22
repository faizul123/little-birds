package com.srvy.dao.impl;

import java.util.List;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.srvy.dao.inf.TopicDao;
import com.srvy.model.Topic;

public class TopicDaoImpl extends BaseDaoImpl implements TopicDao {

	private Objectify ofy;
	
	public TopicDaoImpl(Objectify ofy) {
		this.ofy = ofy;
	}
	
	@Override
	public List<Topic> getTopics(int offset, int limit) {
		return updateResult(ofy.load().type(Topic.class).offset(offset).limit(limit).list());
	}

	@Override
	public Topic getTopic(String value, boolean idOrSlug) {
		
		if(idOrSlug){			
			return updateResult(getTopic(value));			
		}else{
			Topic topic = ofy.load().type(Topic.class).filter("slug", value).first().now();
			return updateResult(topic);
		}
		
	}
	
	private Topic getTopic(String id){
		Key<Topic> topicKey = Key.create(Topic.class, id);
		return ofy.load().key(topicKey).now();
	}

	@Override
	public List<Topic> getTopics(List<String> topicIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Topic> getHotSubscribedTopics() {
		// TODO Auto-generated method stub
		return null;
	}

}
