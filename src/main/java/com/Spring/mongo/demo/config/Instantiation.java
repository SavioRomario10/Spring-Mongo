package com.Spring.mongo.demo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.Spring.mongo.demo.dto.AuthorDTO;
import com.Spring.mongo.demo.dto.ComentDTO;
import com.Spring.mongo.demo.domain.User;
import com.Spring.mongo.demo.repositories.UserRepository;

import com.Spring.mongo.demo.domain.Post;
import com.Spring.mongo.demo.repositories.PostRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

  @Autowired
  private UserRepository repository;

  @Autowired
  private PostRepository postRepository;

  @Override
  public void run(String... args) throws Exception {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

    repository.deleteAll();

    User us1 = new User(null, "Maria", "K7d9U@example.com");
    User us2 = new User(null, "Alex", "V2r6t@example.com");
    User us3 = new User(null, "Bob", "V2r6t@example.com");

    repository.saveAll(Arrays.asList(us1, us2, us3));

    Post p1 = new Post(null, sdf.parse("21/03/2018 13:05:44"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(us1));
    Post p2 = new Post(null, sdf.parse("21/03/2018 13:05:44"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(us2));

    ComentDTO cm1 = new ComentDTO("Boa viagem", sdf.parse("21/03/2018 13:05:44"), new AuthorDTO(us3));
    ComentDTO cm2 = new ComentDTO("Aproveite", sdf.parse("21/03/2018 13:05:44"), new AuthorDTO(us2));
    ComentDTO cm3 = new ComentDTO("Tenha um ótimo dia", sdf.parse("21/03/2018 13:05:44"), new AuthorDTO(us1));

    postRepository.saveAll(Arrays.asList(p1, p2));

    us1.getPosts().addAll(Arrays.asList(p1, p2));
    repository.save(us1);
  }
}