package com.example.cinema.models.dto.request;

import com.example.cinema.base.BaseDto;
import com.example.cinema.models.entity.Cinema;
import com.example.cinema.models.enums.HallType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HallCreateRequest {
    String name;
    HallType hallType;
    private int rows;
    private int places;
    Long cinemaId;
}
