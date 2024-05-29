package com.example.cinema.service.impl;

import com.example.cinema.models.dto.response.FilmR.FilmsResponse;
import com.example.cinema.utils.Language;
import com.example.cinema.base.BaseServiceImpl;
import com.example.cinema.exceptions.FilmDurationError;
import com.example.cinema.exceptions.NotFoundByIDException;
import com.example.cinema.exceptions.OperationFailed;
import com.example.cinema.microservice.FileResponse;
import com.example.cinema.microservice.FileService;
import com.example.cinema.models.dto.request.FilmCreateRequest;
import com.example.cinema.models.dto.FilmDto;
import com.example.cinema.models.dto.response.CinemaR.SeatsResponse;
import com.example.cinema.models.dto.response.FilmR.FilmResponse;
import com.example.cinema.models.dto.response.FilmR.SessionRes;
import com.example.cinema.models.dto.response.Response;
import com.example.cinema.models.entity.Films;
import com.example.cinema.models.entity.Seats;
import com.example.cinema.models.entity.Session;
import com.example.cinema.models.mappers.FilmMapper;
import com.example.cinema.repo.FilmRepo;
import com.example.cinema.service.CinemaService;
import com.example.cinema.service.FilmService;
import com.example.cinema.service.SeatsService;
import com.example.cinema.service.SessionService;
import com.example.cinema.utils.ResourceBundle;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@Service
public class FilmServiceImpl extends BaseServiceImpl<Films, FilmDto, FilmMapper, FilmRepo> implements FilmService {
    public FilmServiceImpl(FilmRepo rep, FilmMapper filmMapper, FilmRepo filmRepo, FileService fileService, SessionService sessionService, CinemaService cinemaService, SeatsService seatsService) {
        super(rep, filmMapper);
        this.filmRepo = filmRepo;
        this.fileService = fileService;
        this.sessionService = sessionService;
        this.cinemaService = cinemaService;
        this.seatsService = seatsService;
    }
    private static final Logger logger = Logger.getLogger(FilmServiceImpl.class.getName());

    private final FilmRepo filmRepo;
    private final FileService fileService;
    private final SessionService sessionService;
    private final CinemaService cinemaService;
    private final SeatsService seatsService;

    @Override
    public Response filmCreate(FilmCreateRequest request, Language language) {
        try {
            FilmDto filmDto = new FilmDto();
            filmDto.setName(request.getName());
            FileResponse fileResponse = fileService.upload(request.getLogo());
            filmDto.setLogo(fileResponse.getDownloadUri());
            filmDto.setYear(request.getYear());
            filmDto.setGenre(request.getGenre());
            filmDto.setDuration(request.getDuration());
            int duration = request.getDuration();
            if (duration > 0) {
                filmDto.setDuration(duration);
            } else {
               throw new FilmDurationError("filmDuration", language);
            }
            filmDto.setCountry(request.getCountry());
            filmDto.setTrailer(request.getTrailer());
            filmDto.setAge(request.getAge());
            save(filmDto);
            return new Response(ResourceBundle.periodMessages("created", language));
        } catch (Exception e) {
            logger.log(Level.SEVERE, "nigger: " + e.getMessage(), e);
            throw new OperationFailed(ResourceBundle.periodMessages("operationFailed", language));
        }
    }

    @Override
    public FilmResponse allFilm(Long idFilm, Language language, String sDate) {
        LocalDate date = LocalDate.parse(sDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        FilmResponse response = new FilmResponse();
        Films film = filmRepo.findByFilmIdAndDate(idFilm,date);
        if (film==null){
            throw  new NotFoundByIDException(ResourceBundle.periodMessages("notFoundById", language));
        }
        response.setLogo(film.getLogo());
        response.setName(film.getName());

            List<SessionRes> sessionResponses = new ArrayList<>();
            for (Session session : sessionService.sessionByFilmId(idFilm)) {
                SessionRes sessionResponse = new SessionRes();
                sessionResponse.setCinemaName(session.getHall().getCinema().getName());
                sessionResponse.setHallName(session.getHall().getName());
                sessionResponse.setLocalDate(session.getDate());
                sessionResponse.setLocalTime(session.getTime());
                sessionResponse.setPrice(session.getPrice());
                sessionResponse.setPriceForChildren(session.getPriceForChild());

                List<SeatsResponse> seatsResponses = new ArrayList<>();
                for (Seats seats : seatsService.findSeatsByHallID(session.getHall().getId())) {
                    SeatsResponse seatsResponse = new SeatsResponse();
                    seatsResponse.setRow(seats.getRow());
                    seatsResponse.setPlace(seats.getPlace());
                    seatsResponse.setBooked(seats.isBooked());

                    seatsResponses.add(seatsResponse);
                }

                sessionResponse.setSeatsResponse(seatsResponses);
                sessionResponses.add(sessionResponse);
            }

        response.setSessionResponses(sessionResponses);
        return response;
    }

    @Override
    public List<FilmsResponse> getAllFilms(int offset, int limit) {
        Page<FilmsResponse> pageResult = filmRepo.getAllFilms(PageRequest.of(offset, limit));
        return pageResult.getContent();
    }
}
