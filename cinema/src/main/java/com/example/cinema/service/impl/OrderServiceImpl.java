package com.example.cinema.service.impl;

import com.example.cinema.base.BaseServiceImpl;
import com.example.cinema.models.dto.OrderDto;
import com.example.cinema.models.entity.Order;
import com.example.cinema.models.mappers.OrderMapper;
import com.example.cinema.repo.OrderRepo;
import com.example.cinema.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends BaseServiceImpl<Order, OrderDto, OrderMapper, OrderRepo> implements OrderService {


    public OrderServiceImpl(OrderRepo rep, OrderMapper orderMapper) {
        super(rep, orderMapper);
    }
}
