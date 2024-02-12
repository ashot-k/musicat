package com.ashot.musicat.utils;


public class ExceptionMessages {
    public static String EntityNotFoundException(String entityName, Number id){
        return "Could not find " + entityName + " with identifier: " + id;
    }

}
