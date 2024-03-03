package com.example.cinema.models.mappers;

import com.example.cinema.models.dto.SeatsDto;
import com.example.cinema.models.entity.Seats;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SeatsMapper {

    SeatsDto entityToDto(Seats entity);

    Seats dtoToEntity(SeatsDto dto);

    List<SeatsDto> toDto(List<Seats> entities);
    List<Seats> toEntity(List<SeatsDto> dtos);

    // You may need to clarify the purpose of this method
    SeatsDto update(SeatsDto dto);
}
