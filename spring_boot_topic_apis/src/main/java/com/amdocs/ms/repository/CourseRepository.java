package com.amdocs.ms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.amdocs.ms.models.Course;

public interface CourseRepository extends CrudRepository<Course, String> {
	
	public List<Course> findByTopicId(String topicId);

}
