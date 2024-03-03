package com.example.cinema.service;

import com.example.cinema.models.dto.response.CinemaR.CinemasResponse;
import com.example.cinema.models.dto.response.FilmR.FilmsResponse;
import com.example.cinema.utils.Language;
import com.example.cinema.base.BaseService;
import com.example.cinema.models.dto.request.CinemaCreateRequest;
import com.example.cinema.models.dto.CinemaDto;
import com.example.cinema.models.dto.response.CinemaR.CinemaResponse;
import com.example.cinema.models.dto.response.Response;
import com.example.cinema.models.entity.Cinema;

import java.util.List;


public interface CinemaService extends BaseService<CinemaDto> {
     Response createCinema(CinemaCreateRequest request, Language language);
     CinemaResponse allCinema(Long idCinema, Language language, String date);
     Cinema findByIdCinema(Long idCinema);

     List<CinemasResponse> getAllFilms(int offset, int limit);
     Cinema findCinemasByUsername(String username);

}
