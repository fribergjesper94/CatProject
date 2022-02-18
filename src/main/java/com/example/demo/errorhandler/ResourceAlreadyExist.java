package com.example.demo.errorhandler;

public class ResourceAlreadyExist extends RuntimeException {

    public ResourceAlreadyExist(String message) {
        super(message);
    }
}