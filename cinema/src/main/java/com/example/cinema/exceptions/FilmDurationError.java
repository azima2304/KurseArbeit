package com.example.cinema.exceptions;

import com.example.cinema.utils.Language;

public class FilmDurationError extends RuntimeException {

    public FilmDurationError(String message, Language language) {
        super(message);
    }
}
