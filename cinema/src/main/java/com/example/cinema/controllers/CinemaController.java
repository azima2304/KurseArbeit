package com.example.cinema.controllers;

import com.example.cinema.utils.Language;
import com.example.cinema.models.dto.request.CinemaCreateRequest;
import com.example.cinema.models.dto.response.CinemaR.CinemaResponse;
import com.example.cinema.service.CinemaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cinema")
@RequiredArgsConstructor
@Api(tags = "Cinemas")
public class CinemaController {

    private final CinemaService cinemaService;

    @PostMapping("/create")
    @ApiOperation("Создание кинотеатра")
    ResponseEntity<?> createCinema(@ModelAttribute CinemaCreateRequest request, @RequestParam Language language){
        try {
            return new ResponseEntity<>(cinemaService.createCinema(request, language), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("get/session/by/cinema/{id}")
    @ApiOperation("Все сеансы и места в одном кинотеатре в данное время: ")
    public ResponseEntity<CinemaResponse> getCinemaById(@PathVariable Long id, @RequestParam Language language, String date) {
        CinemaResponse cinemaResponse = cinemaService.allCinema(id, language, date);

        if (cinemaResponse != null) {
            return new ResponseEntity<>(cinemaResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/get/cinemas")
    @ApiOperation("Находим все кинотеатры: ")
    ResponseEntity<?> getAllCinemas( @RequestParam int offset, @RequestParam int limit){
        return ResponseEntity.ok(cinemaService.getAllFilms(offset, limit));
    }




}
