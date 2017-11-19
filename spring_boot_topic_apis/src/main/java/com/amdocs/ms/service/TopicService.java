package com.amdocs.ms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.ms.models.Topic;
import com.amdocs.ms.repository.TopicRepository;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
		
	public List<Topic> getAllTopics() {
		List<Topic> localTopics = new ArrayList<>();
		topicRepository.findAll().forEach(topic -> {
			localTopics.add(topic);
		});
		
		return localTopics;
	}
	
	public Topic getTopic(String id) {
		
		return topicRepository.findOne(id);
	}

	public void updateTopic(Topic newTopic, String id) {
		topicRepository.save(newTopic);
	}

	public void deleteTopic(String id) {
		topicRepository.delete(id);
	}

	public Topic createTopic(Topic topic) {
		return topicRepository.save(topic);
	}
}
