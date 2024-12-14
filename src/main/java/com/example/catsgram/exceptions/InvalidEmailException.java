package com.example.catsgram.exceptions;

public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException() {
        super();
    }

    public InvalidEmailException(String message) {
        super(message);
    }
}
