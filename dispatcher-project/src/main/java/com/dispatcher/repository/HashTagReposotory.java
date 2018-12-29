package com.dispatcher.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.dispatcher.entities.HashTag;

public interface HashTagReposotory extends MongoRepository<HashTag, String> {

}
