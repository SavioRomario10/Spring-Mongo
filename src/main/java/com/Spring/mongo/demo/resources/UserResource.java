package com.Spring.mongo.demo.resources;

import java.util.List;

import com.Spring.mongo.demo.services.UserService;
import com.Spring.mongo.demo.domain.User;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

  @Autowired
  private UserService service;

  @GetMapping
  public ResponseEntity<List<User>> findAll() {
    List<User> list = service.findAll();
    return ResponseEntity.ok().body(list);
  }
}
