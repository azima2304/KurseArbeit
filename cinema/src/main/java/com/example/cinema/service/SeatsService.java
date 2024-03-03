package com.example.cinema.service;


import com.example.cinema.models.entity.Seats;
import feign.Param;

import java.util.List;

public interface SeatsService {
    Seats save(Seats seats);

    List<Seats> findSeatsByHallID(Long hallId);
}
