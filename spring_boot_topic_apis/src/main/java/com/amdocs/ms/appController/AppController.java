package com.amdocs.ms.appController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.ms.models.Course;
import com.amdocs.ms.models.Topic;
import com.amdocs.ms.service.CourseService;
import com.amdocs.ms.service.TopicService;

@RestController
public class AppController {

	@Autowired
	private TopicService topicService;
	
	@Autowired
	private CourseService courseService;
	
	
	@RequestMapping(value = "/topics", method = {RequestMethod.GET}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	@RequestMapping(value="/topic", method = {RequestMethod.POST}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public Topic createTopic(@RequestBody Topic topic) {
		return topicService.createTopic(topic);
	}
	
	@RequestMapping(value = "/topic/{id}", method = {RequestMethod.GET}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public Topic getTopic(@PathVariable("id") String id) {
		return topicService.getTopic(id);
	}
	
	@RequestMapping(value = "/topic/{id}", method = {RequestMethod.PUT}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public void updateTopic(@RequestBody Topic topic, @PathVariable("id") String id) {
		topicService.updateTopic(topic, id);
	}
	
	
	@RequestMapping(value = "/topic/{id}", method = {RequestMethod.DELETE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public void deleteTopic(@PathVariable("id") String id) {
		topicService.deleteTopic(id);
	}
	

	
//	the following API is for course APIs

	@RequestMapping(value = "/courses", method = {RequestMethod.GET}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Course> getAllCourses() {
		return courseService.getAllCourses();
	}
	
	@RequestMapping(value="/{topicId}/course", method = {RequestMethod.POST}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public Course createCourse(@RequestBody Course course,@PathVariable("topicId") String topicId) {
		return courseService.createCourse(course, topicId);
	}

	@RequestMapping(value = "/topic/{topicId}/courses", method = {RequestMethod.GET}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Course> getCourse(@PathVariable("topicId") String topicId) {
		return courseService.findByTopicId(topicId);
	}
}
