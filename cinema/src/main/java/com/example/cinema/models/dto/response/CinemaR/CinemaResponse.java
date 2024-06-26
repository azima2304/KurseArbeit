package com.example.cinema.models.dto.response.CinemaR;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CinemaResponse {
    Long id;
    String logo;
    String name;
    List<HallResponse> hallResponse;
}
