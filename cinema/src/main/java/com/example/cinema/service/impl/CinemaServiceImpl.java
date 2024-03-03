package com.example.cinema.service.impl;

import com.example.cinema.exceptions.NotFoundByDate;
import com.example.cinema.models.dto.response.CinemaR.*;
import com.example.cinema.models.dto.response.FilmR.FilmsResponse;
import com.example.cinema.utils.Language;
import com.example.cinema.base.BaseServiceImpl;
import com.example.cinema.exceptions.NotFoundByIDException;
import com.example.cinema.exceptions.OperationFailed;
import com.example.cinema.microservice.FileResponse;
import com.example.cinema.microservice.FileService;
import com.example.cinema.models.dto.request.CinemaCreateRequest;
import com.example.cinema.models.dto.CinemaDto;
import com.example.cinema.models.dto.response.Response;
import com.example.cinema.models.entity.Cinema;
import com.example.cinema.models.entity.Hall;
import com.example.cinema.models.entity.Seats;
import com.example.cinema.models.entity.Session;
import com.example.cinema.models.mappers.CinemaMapper;
import com.example.cinema.repo.CinemaRepo;
import com.example.cinema.service.CinemaService;
import com.example.cinema.service.HallService;
import com.example.cinema.service.SeatsService;
import com.example.cinema.service.SessionService;
import com.example.cinema.utils.ResourceBundle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class CinemaServiceImpl extends BaseServiceImpl<Cinema, CinemaDto, CinemaMapper, CinemaRepo> implements CinemaService {


    public CinemaServiceImpl(CinemaRepo rep, CinemaMapper cinemaMapper, CinemaRepo repository, FileService fileService, SessionService sessionService, HallService hallService, SeatsService seatsService) {
        super(rep, cinemaMapper);
        this.repository = repository;
        this.fileService = fileService;
        this.sessionService = sessionService;
        this.hallService = hallService;
        this.seatsService = seatsService;
    }
    private final CinemaRepo repository;
    private final FileService fileService;
    private final SessionService sessionService;
    private final HallService hallService;
    private final SeatsService seatsService;

    @Override
    public Response createCinema(CinemaCreateRequest request, Language language) {
        try {
            CinemaDto cinemaDto = new CinemaDto();
            cinemaDto.setName(request.getName());
            FileResponse fileResponse = fileService.upload(request.getLogo());
            cinemaDto.setLogo(fileResponse.getDownloadUri());
            cinemaDto.setDescription(request.getDescription());
            cinemaDto.setAddress(request.getAddress());
            cinemaDto.setPassword(request.getPassword());
            cinemaDto.setUsername(request.getUsername());
            save(cinemaDto);
            return new Response(ResourceBundle.periodMessages("created", language));
        }catch (OperationFailed e ){
            throw new OperationFailed(ResourceBundle.periodMessages("operationFailed", language));
        }
    }





    @Override
    public CinemaResponse allCinema(Long idCinema, Language language, String date) {
        LocalDate sessionDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        CinemaResponse response = new CinemaResponse();

        Cinema cinema = repository.findByIdCinema(idCinema);
        if (cinema==null){
            throw new NotFoundByIDException(ResourceBundle.periodMessages("notFoundById", language));
        }
        response.setLogo(cinema.getLogo());
        response.setName(cinema.getName());
        List<HallResponse> hallResponses = new ArrayList<>();
        for (Hall hall : hallService.findByCinemaId(idCinema)) {
            HallResponse hallResponse = new HallResponse();
            hallResponse.setName(hall.getName());

            List<SessionResponse> sessionResponses = new ArrayList<>();
            for (Session session : sessionService.findByHallAndDate(hall, sessionDate)) {
                if (session==null){
                    throw new NotFoundByDate(ResourceBundle.periodMessages("notFoundByDate", language));
                }
                SessionResponse sessionResponse = new SessionResponse();
                sessionResponse.setFilmName(session.getFilm().getName());
                sessionResponse.setLocalDate(session.getDate());
                sessionResponse.setLocalTime(session.getTime());
                sessionResponse.setPrice(session.getPrice());
                sessionResponse.setPriceForChildren(session.getPriceForChild());

                List<SeatsResponse> seatsResponses = new ArrayList<>();
                for (Seats seats : seatsService.findSeatsByHallID(hall.getId())) {
                    SeatsResponse seatsResponse = new SeatsResponse();
                    seatsResponse.setRow(seats.getRow());
                    seatsResponse.setPlace(seats.getPlace());
                    seatsResponse.setBooked(seats.isBooked());

                    seatsResponses.add(seatsResponse);
                }

                sessionResponse.setSeatsResponse(seatsResponses);
                sessionResponses.add(sessionResponse);
            }

            hallResponse.setSessionResponse(sessionResponses);
            hallResponses.add(hallResponse);
        }

        response.setHallResponse(hallResponses);
        return response;

    }

    @Override
    public Cinema findByIdCinema(Long idCinema) {
        return repository.findByIdCinema(idCinema);
    }

    @Override
    public List<CinemasResponse> getAllFilms(int offset, int limit) {
            Page<CinemasResponse> pageResult = repository.getAllCinemas(PageRequest.of(offset, limit));
            return pageResult.getContent();
    }

    @Override
    public Cinema findCinemasByUsername(String username) {
        return repository.findCinemasByUsername(username);
    }
}




