package com.example.cinema.models.dto.request;


import com.example.cinema.base.BaseDto;
import com.example.cinema.models.enums.Genre;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Time;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FilmCreateRequest {
    String name;
    MultipartFile logo;
    int year;
    Genre genre;
    int duration;
    String description;
    String country;
    String trailer;
    int age;

}
