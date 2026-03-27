package com.Spring.mongo.demo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.mongo.demo.domain.User;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

  @GetMapping
  public ResponseEntity<List<User>> findAll() {
    User maria = new User("1", "Maria Brown", "6oK7j@example.com");
    User alex = new User("2", "Alex Green", "W3oVt@example.com");

    List<User> list = new ArrayList<>();
    list.addAll(Arrays.asList(maria, alex));
    return ResponseEntity.ok().body(list);
  }
}
