package com.example.cinema.models.dto;

import com.example.cinema.base.BaseDto;

import com.example.cinema.models.entity.Hall;
import lombok.*;
import lombok.experimental.FieldDefaults;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SeatsDto  {

    Long id;

    Byte row;
    Byte place;

    Hall hall;

    boolean isBooked;
}
