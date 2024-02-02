package com.example.spring.exception.custom;

public class ResourceNotFound extends Exception{
    public ResourceNotFound(String s) {
        super(s);
    }
}
