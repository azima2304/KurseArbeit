package com.example.cinema.models.dto;

import com.example.cinema.base.BaseDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class CinemaDto extends BaseDto {
    Long id;
    String name;
    String logo;
    String description;
    String address;
    String username;
    String password;
}
