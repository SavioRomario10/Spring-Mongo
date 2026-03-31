package com.Spring.mongo.demo.services;

import java.util.List;

import com.Spring.mongo.demo.domain.User;
import com.Spring.mongo.demo.repositories.UserRepository;
import com.Spring.mongo.demo.services.exception.ObjectNotFoundException;

import com.Spring.mongo.demo.dto.UserDTO;
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
    User user = repository.findById(id).orElse(null); 
    if(user == null){
      throw new ObjectNotFoundException("Objeto não encontrado");
    }
    return user;
  }

  public User insert(User obj){
    return repository.insert(obj);
  }

  public User fromDTO(UserDTO objDto){
    return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
  }

  public void delete(String id){
    findById(id);
    repository.deleteById(id);
  }

  public User update(User obj){
    User newUser = repository.findById(obj.getId()).orElse(null);
    updateData(newUser, obj);
    return repository.save(newUser);
  }

  public void updateData(User newUser, User obj){
    newUser.setName(obj.getName());
    newUser.setEmail(obj.getEmail());
  }
}