package com.ashot.musicat.controller;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class MusicatControllerAdvice {

    @ExceptionHandler
    public String entityNotFoundHandler(EntityNotFoundException e){
        return e.getMessage();
    }




}
