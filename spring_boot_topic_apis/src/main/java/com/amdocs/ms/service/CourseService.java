package com.amdocs.ms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.ms.models.Course;
import com.amdocs.ms.models.Topic;
import com.amdocs.ms.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
		
	public List<Course> getAllCourses() {
		List<Course> localCourses = new ArrayList<>();
		courseRepository.findAll().forEach(course -> {
			localCourses.add(course);
		});
		
		return localCourses;
	}
	
	public Course getCourse(String id) {
		
		return courseRepository.findOne(id);
	}

	public void updateCourse(Course newCourse, String id) {
		courseRepository.save(newCourse);
	}

	public void deleteCourse(String id) {
		courseRepository.delete(id);
	}


	public Course createCourse(Course course, String topicId) {
		Topic dummyTopic = new Topic(topicId, "", "");
		course.setTopic(dummyTopic);
		return courseRepository.save(course);
	}

	public List<Course> findByTopicId(String topicId) {
		return courseRepository.findByTopicId(topicId);
	}
	
	
}
