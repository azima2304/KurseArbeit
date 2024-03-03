package com.example.cinema.models.dto.response.FilmR;

import com.example.cinema.models.dto.response.CinemaR.SeatsResponse;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SessionRes {
    String cinemaName;
    String hallName;
    LocalDate localDate;
    LocalTime localTime;
    int price;
    int priceForChildren;
    List<SeatsResponse> seatsResponse;
}
