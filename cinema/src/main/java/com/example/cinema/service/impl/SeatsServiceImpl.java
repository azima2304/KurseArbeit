package com.example.cinema.service.impl;

import com.example.cinema.models.entity.Seats;
import com.example.cinema.repo.SeatsRepo;
import com.example.cinema.service.SeatsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatsServiceImpl implements SeatsService {

    private final SeatsRepo seatsRepo;

    public SeatsServiceImpl(SeatsRepo seatsRepo) {
        this.seatsRepo = seatsRepo;
    }

    @Override
    public Seats save(Seats seats) {
        return seatsRepo.save(seats);
    }

    @Override
    public List<Seats> findSeatsByHallID(Long hallId) {
        return seatsRepo.findSeatsByHallID(hallId);
    }
}
