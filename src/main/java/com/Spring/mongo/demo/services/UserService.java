package com.Spring.mongo.demo.services;

import java.util.List;

import com.Spring.mongo.demo.domain.User;
import com.Spring.mongo.demo.repositories.UserRepository;
import com.Spring.mongo.demo.services.exception.ObjectNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

@Service
public class UserService {

  @Autowired
  private UserRepository repository;

  public List<User> findAll() {
    return repository.findAll();
  }

  public User findById(String id){
    User user = repository.findOne(id);
    if(user == null){
      throw new ObjectNotFoundException("Objeto não encontrado")
    }
    return user;
  }
}