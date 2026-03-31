package com.Spring.mongo.demo.repositories;

import org.springframework.stereotype.Repository;

import com.Spring.mongo.demo.domain.Post;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
  @Query("{'title': {$regex: ?0, $options: 'i'}}")
  List<Post> findByTitle(String text);

  List<Post> findByTitleContainingIgnoreCase(String text);

}
