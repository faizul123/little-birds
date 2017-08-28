package com.srvy.dao.inf;

import java.util.List;

import com.srvy.model.Topic;

public interface TopicDao extends BaseDao {
	
	public List<Topic> getTopics(int page,int offset);
	
	public Topic getTopic(String value,boolean idOrSlug);
	
	public List<Topic> getTopics(List<String> topicIds);
	
	public List<Topic> getHotSubscribedTopics();
}
