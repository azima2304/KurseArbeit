package com.example.cinema.models.mappers;


import com.example.cinema.base.BaseMapper;
import com.example.cinema.models.dto.SessionSeatsDto;
import com.example.cinema.models.entity.SessionSeats;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface SessionSeatsMapper extends BaseMapper<SessionSeats, SessionSeatsDto> {

    SessionSeatsMapper MAPPER = Mappers.getMapper(SessionSeatsMapper.class);
}
