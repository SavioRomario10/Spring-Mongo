package com.Spring.mongo.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.Spring.mongo.demo.domain.User;
import com.Spring.mongo.demo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

  @Autowired
  private UserRepository repository;

  @Override
  public void run(String... args) throws Exception {

    repository.deleteAll();

    User us1 = new User(null, "Maria", "K7d9U@example.com");
    User us2 = new User(null, "Alex", "V2r6t@example.com");
    User us3 = new User(null, "Bob", "V2r6t@example.com");

    repository.saveAll(Arrays.asList(us1, us2, us3));
  }
}