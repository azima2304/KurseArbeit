package com.example.cinema.models.dto;


import com.example.cinema.base.BaseDto;
import com.example.cinema.models.entity.Seats;
import com.example.cinema.models.entity.Session;
import com.example.cinema.models.enums.PriceType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SessionSeatsDto extends BaseDto {

    Seats seat;
    Session session;
    PriceType priceType;
}
