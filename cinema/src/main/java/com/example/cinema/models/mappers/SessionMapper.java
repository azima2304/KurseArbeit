package com.example.cinema.models.mappers;

import com.example.cinema.base.BaseMapper;
import com.example.cinema.models.dto.SessionDto;
import com.example.cinema.models.entity.Session;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface SessionMapper extends BaseMapper<Session, SessionDto> {

}
