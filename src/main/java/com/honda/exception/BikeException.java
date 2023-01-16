package com.honda.exception;

public class BikeException extends RuntimeException{

    private String message;

    public BikeException(String message) {
        super(message);
        this.message = message;
    }
}
