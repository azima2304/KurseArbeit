package com.example.cinema.models.mappers;

import com.example.cinema.base.BaseMapper;
import com.example.cinema.models.dto.HallDto;
import com.example.cinema.models.entity.Hall;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface HallMapper extends BaseMapper<Hall, HallDto> {
    HallMapper MAPPER = Mappers.getMapper(HallMapper.class);
}
