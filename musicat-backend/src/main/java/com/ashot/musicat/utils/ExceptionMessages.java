package com.ashot.musicat.utils;


public class ExceptionMessages {
    public static String EntityNotFoundException(String entityName, Number id){
        return "Could not find " + entityName + " with id: " + id;
    }
    public static String EntityNotFoundException(String entityName, String term){
        return "Could not find " + entityName + " with " + term;
    }

}
