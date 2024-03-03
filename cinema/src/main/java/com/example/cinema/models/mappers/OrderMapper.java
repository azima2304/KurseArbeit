package com.example.cinema.models.mappers;


import com.example.cinema.base.BaseMapper;
import com.example.cinema.models.dto.OrderDto;
import com.example.cinema.models.entity.Order;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface OrderMapper extends BaseMapper<Order, OrderDto> {

    OrderMapper MAPPER = Mappers.getMapper(OrderMapper.class);
}
