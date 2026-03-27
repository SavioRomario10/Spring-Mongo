package com.Spring.mongo.demo.services;

import java.util.List;

import com.Spring.mongo.demo.domain.User;
import com.Spring.mongo.demo.repositories.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {

  @Autowired
  private UserRepository repository;

  public List<User> findAll() {
    return repository.findAll();
  }
}