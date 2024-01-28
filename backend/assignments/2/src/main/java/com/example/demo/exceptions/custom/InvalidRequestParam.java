package com.example.demo.exceptions.custom;

public class InvalidRequestParam extends RuntimeException {

    public InvalidRequestParam(String message) {
        super(message);
    }
}
