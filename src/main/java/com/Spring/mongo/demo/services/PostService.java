package com.Spring.mongo.demo.services;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.mongo.demo.domain.Post;  
import com.Spring.mongo.demo.repositories.PostRepository;
import com.Spring.mongo.demo.services.exception.ObjectNotFoundException;


@Service
public class PostService {

  @Autowired
  private PostRepository repository;

  public Post findById(String id){
    Post post = repository.findById(id).orElse(null);
    if(post == null){
      throw new ObjectNotFoundException("Objeto não encontrado");
    }
    return post;
  }

  public List<Post> findByTitle(String text){
    return repository.findByTitleContainingIgnoreCase(text);
  }

  public List<Post> findByTitleQuery(String text){
    return repository.findByTitle(text);
  }

  public List<Post> fullSearch(String text, Date minDate, Date maxDate){
    maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);

    return repository.fullSearch(text, minDate, maxDate);
  }
}