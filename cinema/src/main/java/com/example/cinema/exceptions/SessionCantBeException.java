package com.example.cinema.exceptions;

public class SessionCantBeException extends RuntimeException{
    public SessionCantBeException(String message) {
        super(message);
    }
}
