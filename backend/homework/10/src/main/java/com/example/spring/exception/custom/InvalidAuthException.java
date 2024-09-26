package com.example.spring.exception.custom;

public class InvalidAuthException extends IndexOutOfBoundsException {
    public InvalidAuthException(String s) {
        super(s);
    }

}
