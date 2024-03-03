package com.example.cinema.exceptions;

public class TokenValidationEx extends RuntimeException {
    public TokenValidationEx(String message) {
        super(message);
    }
}
