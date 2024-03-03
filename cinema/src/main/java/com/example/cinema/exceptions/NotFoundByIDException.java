package com.example.cinema.exceptions;

public class NotFoundByIDException extends RuntimeException{
    public NotFoundByIDException(String message) {
        super(message);
    }
}
