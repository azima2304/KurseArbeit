package com.example.cinema.models.mappers;

import com.example.cinema.base.BaseMapper;
import com.example.cinema.models.dto.OrderSessionSeatsDto;
import com.example.cinema.models.entity.OrderSessionSeats;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface OrderSessionSeatsMapper extends BaseMapper<OrderSessionSeats, OrderSessionSeatsDto> {

    OrderSessionSeatsMapper MAPPER = Mappers.getMapper(OrderSessionSeatsMapper.class);
}
