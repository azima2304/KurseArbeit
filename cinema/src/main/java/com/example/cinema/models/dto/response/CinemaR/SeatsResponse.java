package com.example.cinema.models.dto.response.CinemaR;

import com.example.cinema.models.enums.PriceType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SeatsResponse {
    int row;
    int place;
    boolean isBooked;

}
