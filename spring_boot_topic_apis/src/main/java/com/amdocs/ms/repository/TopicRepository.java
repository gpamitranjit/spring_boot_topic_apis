package com.amdocs.ms.repository;

import org.springframework.data.repository.CrudRepository;

import com.amdocs.ms.models.Topic;

public interface TopicRepository extends CrudRepository<Topic, String> {

}
