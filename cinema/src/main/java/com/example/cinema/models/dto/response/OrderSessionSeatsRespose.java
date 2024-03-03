package com.example.cinema.models.dto.response;


import com.example.cinema.models.dto.request.SeatsRequest;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderSessionSeatsRespose {
    String filmName;
    String cinemaName;
    String hallName;
    List<SeatsRequest> seats;
    int totalPrice;
    String clientEmail;
}
