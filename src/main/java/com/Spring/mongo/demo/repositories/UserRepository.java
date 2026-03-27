package com.Spring.mongo.demo.repositories;

import org.springframework.stereotype.Repository;
import com.Spring.mongo.demo.domain.User;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
