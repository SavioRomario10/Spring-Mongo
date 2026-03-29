package com.Spring.mongo.demo.resources;

import java.util.List;
import java.util.stream.Collectors;

import com.Spring.mongo.demo.services.UserService;

import ch.qos.logback.core.joran.spi.HttpUtil.RequestMethod;

import com.Spring.mongo.demo.domain.User;
import com.Spring.mongo.demo.dto.UserDTO;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

  @Autowired
  private UserService service;

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<UserDTO>> findAll() {
    List<User> list = service.findAll();
    List<UserDTO> listDto = list.stream().map(x-> new UserDTO(x)).collect(Collectors.toList());
    return ResponseEntity.ok().body(listDto);
  }

  @RequestMapping(value="/{id}", method= RequestMethod.GET)
  public ResponseEntity<UserDTO> findById(@PathVariable String id){
    User obj = service.findById(id);
    return ResponseEntity.ok().body(new UserDTO(obj));
  }
}