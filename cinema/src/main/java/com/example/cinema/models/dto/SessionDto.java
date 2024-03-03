package com.example.cinema.models.dto;

import com.example.cinema.base.BaseDto;
import com.example.cinema.models.entity.Films;
import com.example.cinema.models.entity.Hall;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SessionDto extends BaseDto {
    Long id;
    LocalTime time;
    LocalDate date;
    Hall hall;
    Films film;
    int priceForChild;
    int price;
}
