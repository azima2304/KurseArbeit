package com.example.cinema.controllers;


import com.example.cinema.utils.Language;
import com.example.cinema.models.dto.request.FilmCreateRequest;
import com.example.cinema.models.dto.response.FilmR.FilmResponse;
import com.example.cinema.service.FilmService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/film")
@Api(tags = "Films")
public class FilmController {
    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @PostMapping("/create")
    @ApiOperation("Создание фильма")
    ResponseEntity<?> createFilm(@ModelAttribute FilmCreateRequest request, @RequestParam Language language){
        try {
            return new ResponseEntity<>(filmService.filmCreate(request, language), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("get/session/by/film/{id}")
    @ApiOperation("Все сеансы данного фильма и в данное время: ")
    public ResponseEntity<FilmResponse> getFilmById(@PathVariable Long id, @RequestParam Language language, String sDate) {
        FilmResponse filmResponse = filmService.allFilm(id, language, sDate);

        if (filmResponse != null) {
            return new ResponseEntity<>(filmResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/get//films")
    ResponseEntity<?> getAllFilms( @RequestParam int offset, @RequestParam int limit){
        return ResponseEntity.ok(filmService.getAllFilms(offset, limit));
    }


}
