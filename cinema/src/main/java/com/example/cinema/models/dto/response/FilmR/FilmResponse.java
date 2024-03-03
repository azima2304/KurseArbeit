package com.example.cinema.models.dto.response.FilmR;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FilmResponse {
    String logo;
    String name;
    List<SessionRes> sessionResponses;
}
