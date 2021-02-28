package com.example.school.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class MainControllerAdvice {
    private final static Logger log = LoggerFactory.getLogger(MainControllerAdvice.class);

    @ExceptionHandler(value = EntityNotFoundException.class)
    public String handleNotFound(){
        return "not-found";
    }

    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public String handleMisMatch(){
        return "400";
    }
}
