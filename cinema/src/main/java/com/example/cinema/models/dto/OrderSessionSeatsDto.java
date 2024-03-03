package com.example.cinema.models.dto;


import com.example.cinema.base.BaseDto;
import com.example.cinema.models.entity.Order;
import com.example.cinema.models.entity.Session;
import com.example.cinema.models.entity.SessionSeats;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderSessionSeatsDto extends BaseDto {
    Long id;
    Order order;
    SessionSeats seatsSession;

}
