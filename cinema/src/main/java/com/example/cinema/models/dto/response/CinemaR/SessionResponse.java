package com.example.cinema.models.dto.response.CinemaR;

import com.example.cinema.models.dto.response.CinemaR.SeatsResponse;
import com.example.cinema.models.enums.PriceType;
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
public class SessionResponse {
    String filmName;
    LocalDate localDate;
    LocalTime localTime;
    int price;
    int priceForChildren;

    List<SeatsResponse> seatsResponse;
}
