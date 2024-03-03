package com.example.cinema.models.dto;


import com.example.cinema.base.BaseDto;
import com.example.cinema.models.enums.Genre;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.sql.Time;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class FilmDto extends BaseDto {
    Long id;
    String name;
    String logo;
    int year;
    Genre genre;
    int duration;
    String description;
    String country;
    String trailer;
    int age;
}
