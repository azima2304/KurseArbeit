package com.example.cinema.exceptions;

public class NotFoundByDate extends RuntimeException {
    public NotFoundByDate(String message) {
        super(message);
    }
}
