package com.example.cinema.service;

import com.example.cinema.utils.Language;
import com.example.cinema.base.BaseService;
import com.example.cinema.models.dto.request.HallCreateRequest;
import com.example.cinema.models.dto.HallDto;
import com.example.cinema.models.dto.response.Response;
import com.example.cinema.models.entity.Hall;

import java.util.List;

public interface HallService extends BaseService<HallDto> {
    Response createHall(HallCreateRequest request, Language language);

    List<Hall> findByCinemaId(Long cinemaId);

    int[][] getHallLayoutById(Long hallId);
}
