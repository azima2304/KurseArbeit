package com.example.cinema.service;

import com.example.cinema.models.dto.response.FilmR.FilmsResponse;
import com.example.cinema.utils.Language;
import com.example.cinema.base.BaseService;
import com.example.cinema.models.dto.request.FilmCreateRequest;
import com.example.cinema.models.dto.FilmDto;
import com.example.cinema.models.dto.response.FilmR.FilmResponse;
import com.example.cinema.models.dto.response.Response;

import java.time.LocalDate;
import java.util.List;


public interface FilmService extends BaseService<FilmDto> {
    Response filmCreate (FilmCreateRequest request, Language language);
    FilmResponse allFilm(Long idFilm, Language language, String date);

    List<FilmsResponse> getAllFilms(int offset, int limit);

}
