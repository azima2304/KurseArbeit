package com.example.cinema.service.impl;

import com.example.cinema.utils.Language;
import com.example.cinema.base.BaseServiceImpl;
import com.example.cinema.exceptions.NotFoundByIDException;
import com.example.cinema.exceptions.SessionCantBeException;
import com.example.cinema.models.dto.*;
import com.example.cinema.models.dto.request.SessionCreateRequest;
import com.example.cinema.models.dto.response.Response;
import com.example.cinema.models.entity.*;
import com.example.cinema.models.mappers.SessionMapper;
import com.example.cinema.repo.FilmRepo;
import com.example.cinema.repo.HallRepo;
import com.example.cinema.repo.SessionRepo;
import com.example.cinema.service.SessionService;
import com.example.cinema.utils.ResourceBundle;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@Service
public class SessionServiceImpl extends BaseServiceImpl<Session, SessionDto, SessionMapper, SessionRepo> implements SessionService {

    private final SessionRepo sessionRepository;

    public SessionServiceImpl(SessionRepo rep, SessionMapper sessionMapper, SessionRepo sessionRepository,FilmRepo filmRepo, HallRepo hallRepo) {
        super(rep, sessionMapper);
        this.sessionRepository = sessionRepository;

        this.filmRepo = filmRepo;
        this.hallRepo = hallRepo;
    }



    private final FilmRepo filmRepo;
    private final HallRepo hallRepo;
    @Override
    public Response createSession(SessionCreateRequest request, Language language) {
        Long filmId = request.getFilmId();
        Optional<Films> optionalFilms = filmRepo.findById(filmId);
        if (optionalFilms == null || optionalFilms.isEmpty()) {
            throw new NotFoundByIDException(ResourceBundle.periodMessages("notFoundById", language));
        }

        Long hallId = request.getHallId();
        Optional<Hall> optionalHall = hallRepo.findById(hallId);

        if (optionalHall == null || optionalHall.isEmpty()) {
            throw new NotFoundByIDException(ResourceBundle.periodMessages("notFoundById", language));
        }

        Films film = optionalFilms.get();
        Hall hall = optionalHall.get();
        LocalDate dateOfSession = request.getDate();
        LocalTime timeOfSession = request.getTime();
        int durationOfFilm = film.getDuration();

        LocalDateTime sessionStart = LocalDateTime.of(dateOfSession, timeOfSession);
        LocalDateTime sessionEnd = sessionStart.plusMinutes(durationOfFilm);


        List<Session> sessionsInHall = sessionRepository.findByHallAndDate(hall, dateOfSession);
        for (Session existingSession : sessionsInHall) {
            LocalDateTime existingSessionStart = LocalDateTime.of(existingSession.getDate(), existingSession.getTime());
            LocalDateTime existingSessionEnd = existingSessionStart.plusMinutes(existingSession.getFilm().getDuration());

            if (sessionStart.isBefore(existingSessionEnd) && sessionEnd.isAfter(existingSessionStart)) {
                throw new SessionCantBeException(ResourceBundle.periodMessages("sessionCantBe", language));
            }
        }

        try {
            SessionDto sessionDto = new SessionDto();
            sessionDto.setTime(request.getTime());
            sessionDto.setDate(request.getDate());
            sessionDto.setFilm(film);
            sessionDto.setHall(hall);
            sessionDto.setPrice(request.getPrice());
            sessionDto.setPriceForChild(request.getPriceForChild());
            save(sessionDto);
        } catch (Exception e) {
            throw new RuntimeException(ResourceBundle.periodMessages("operationFailed", language));
        }

        return new Response(ResourceBundle.periodMessages("created", language));
    }






    @Override
    public List<Session> findByHallId(Long hallId) {
        return sessionRepository.findByHallId(hallId);
    }

    @Override
    public List<Session> sessionByFilmId(Long filmId) {
        return sessionRepository.sessionsByFilmId(filmId);
    }

    @Override
    public List<Session> findByHallAndDate(Hall hall, LocalDate date) {
        return sessionRepository.findByHallAndDate(hall, date);
    }


}

