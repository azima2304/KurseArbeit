package com.example.cinema.exceptions;

public class OperationFailed extends RuntimeException{
    public OperationFailed(String message) {
        super(message);
    }
}
