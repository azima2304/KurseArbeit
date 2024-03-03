package com.example.cinema.models.mappers;

import com.example.cinema.base.BaseMapper;
import com.example.cinema.models.dto.FilmDto;
import com.example.cinema.models.entity.Films;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface FilmMapper extends BaseMapper<Films, FilmDto> {
    FilmMapper MAPPER = Mappers.getMapper(FilmMapper.class);
}
