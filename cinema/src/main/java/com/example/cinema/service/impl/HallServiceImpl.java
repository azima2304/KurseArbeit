package com.example.cinema.service.impl;

import com.example.cinema.utils.Language;
import com.example.cinema.base.BaseServiceImpl;
import com.example.cinema.exceptions.NotFoundByIDException;
import com.example.cinema.models.dto.*;
import com.example.cinema.models.dto.request.HallCreateRequest;
import com.example.cinema.models.dto.response.Response;
import com.example.cinema.models.entity.Cinema;
import com.example.cinema.models.entity.Hall;
import com.example.cinema.models.entity.Seats;
import com.example.cinema.models.mappers.HallMapper;
import com.example.cinema.repo.CinemaRepo;
import com.example.cinema.repo.HallRepo;
import com.example.cinema.service.HallService;
import com.example.cinema.service.SeatsService;
import com.example.cinema.utils.ResourceBundle;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HallServiceImpl extends BaseServiceImpl<Hall, HallDto, HallMapper, HallRepo> implements HallService {
    public HallServiceImpl(HallRepo rep, HallMapper hallMapper, HallRepo hallRepo, CinemaRepo cinemaRepo, SeatsService seatsService) {
        super(rep, hallMapper);
        this.hallRepo = hallRepo;
        this.cinemaRepo = cinemaRepo;
        this.seatsService = seatsService;
    }

    private final HallRepo hallRepo;
    private final CinemaRepo cinemaRepo;
    private final SeatsService seatsService;


    @Override
    public List<Hall> findByCinemaId(Long cinemaId) {
        return hallRepo.findByCinemaId(cinemaId);
    }



    @Override
    public Response createHall(HallCreateRequest request, Language language) {
        Long cinemaId = request.getCinemaId();
        Optional<Cinema> optionalCinema = cinemaRepo.findById(cinemaId);
        if (optionalCinema.isEmpty()){
            throw new NotFoundByIDException(ResourceBundle.periodMessages("notFoundById", language));
        }

        Cinema cinema = optionalCinema.get();
        try {

            Hall hallDto = new Hall();
            hallDto.setName(request.getName());
            hallDto.setHallType(request.getHallType());
            hallDto.setRows(request.getRows());
            hallDto.setPlaces(request.getPlaces());
            hallDto.setCinema(cinema);

            hallRepo.save(hallDto);

            createSeatsForHall(hallDto);

        } catch (Exception e) {
            throw new RuntimeException(ResourceBundle.periodMessages("operationFailed", language));
        }
        return new Response(ResourceBundle.periodMessages("created", language));

    }


    private void createSeatsForHall(Hall hall) {
        int rows = hall.getRows();
        int places = hall.getPlaces();

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= places; j++) {
                Seats seat = new Seats();
                seat.setRow(i);
                seat.setPlace(j);
                seat.setBooked(false);
                seat.setHall(hall);
                seatsService.save(seat);
            }
        }
    }
}



