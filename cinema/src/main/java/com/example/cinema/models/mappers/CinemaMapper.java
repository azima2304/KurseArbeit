package com.example.cinema.models.mappers;

import com.example.cinema.base.BaseMapper;

import com.example.cinema.models.dto.CinemaDto;
import com.example.cinema.models.entity.Cinema;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface CinemaMapper extends BaseMapper<Cinema, CinemaDto>{
    CinemaMapper MAPPER = Mappers.getMapper(CinemaMapper.class);


}
