package com.Spring.mongo.demo.repositories;

import org.springframework.stereotype.Repository;

import com.Spring.mongo.demo.domain.Post;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
