package com.Spring.mongo.demo.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.Spring.mongo.demo.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

  @ExceptionHandler(ObjectNotFoundException.class)
  public ResponseEntity<StanedError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){

    HttpStatus status = HttpStatus.NOT_FOUND;
    StanedError err = new StanedError(System.currentTimeMillis(), 
    
    status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());

    return ResponseEntity.status(status).body(err);
  }
}
