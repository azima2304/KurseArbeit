package com.example.cinema.models.dto.response.CinemaR;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HallResponse {
    Long id;
    String name;
    List<SessionResponse> sessionResponse;
}
