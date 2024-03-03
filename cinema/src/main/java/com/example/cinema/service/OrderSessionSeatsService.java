package com.example.cinema.service;

import com.example.cinema.utils.Language;
import com.example.cinema.base.BaseService;
import com.example.cinema.models.dto.*;
import com.example.cinema.models.dto.request.OrderSessionSeatsCreateRequest;
import com.example.cinema.models.dto.response.OrderSessionSeatsRespose;

public interface OrderSessionSeatsService extends BaseService<OrderSessionSeatsDto> {

    OrderSessionSeatsRespose create(OrderSessionSeatsCreateRequest request, Language language);
  }
