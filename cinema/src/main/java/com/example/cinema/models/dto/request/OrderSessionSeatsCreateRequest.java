package com.example.cinema.models.dto.request;


import com.example.cinema.models.enums.PriceType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderSessionSeatsCreateRequest {
    String clientEmail;
    Long idSession;
    List<SeatsRequest> seats;

}
