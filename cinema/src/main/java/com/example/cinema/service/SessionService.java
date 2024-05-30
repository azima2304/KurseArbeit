package com.example.cinema.service;

import com.example.cinema.models.entity.Hall;
import com.example.cinema.utils.Language;
import com.example.cinema.base.BaseService;
import com.example.cinema.models.dto.*;
import com.example.cinema.models.dto.request.SessionCreateRequest;
import com.example.cinema.models.dto.response.Response;
import com.example.cinema.models.entity.Session;

import java.time.LocalDate;
import java.util.List;

public interface SessionService extends BaseService<SessionDto> {

    Response createSession(SessionCreateRequest request, Language language);

    List<Session> findByHallId(Long hallId);

    List<Session> sessionByFilmId(Long filmId);

    List<Session> findByHallAndDate(Hall hall, LocalDate date);

    void updateSeatsStatusAfterSessionEnd(Long sessionId);


}
