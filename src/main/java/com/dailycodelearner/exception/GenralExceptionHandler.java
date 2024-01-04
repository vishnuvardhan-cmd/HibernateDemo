package com.dailycodelearner.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GenralExceptionHandler {

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<GeneralException> handlePostNotFoundException(PostNotFoundException postNotFoundException){
        GeneralException generalException=new GeneralException();
        generalException.setMessage(postNotFoundException.getMessage());
        generalException.setCode(HttpStatus.NOT_FOUND);
        generalException.setCause(postNotFoundException.getCause());
        return new ResponseEntity<>(generalException,HttpStatus.NOT_FOUND);
    }
}
