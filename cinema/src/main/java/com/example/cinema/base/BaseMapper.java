package com.example.cinema.base;



import com.example.cinema.CycleAvoidingMappingContext;
import org.mapstruct.Context;

import javax.persistence.MappedSuperclass;
import java.util.List;

@MappedSuperclass
public interface BaseMapper<ENTITY extends BaseEntity, DTO extends BaseDto> {
    ENTITY toEntity(DTO dto, @Context CycleAvoidingMappingContext context);
    DTO toDto(ENTITY entity, @Context CycleAvoidingMappingContext context);

    List<ENTITY> toEntityList(List<DTO> dtos, @Context CycleAvoidingMappingContext context);
    List<DTO> toDtoList(List<ENTITY> entities, @Context CycleAvoidingMappingContext context);


}
