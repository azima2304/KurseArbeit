package com.example.cinema.models.dto.request;


import com.example.cinema.models.entity.Films;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SessionCreateRequest {
    @ApiModelProperty(dataType = "java.lang.String", example = "14:20:01")
    LocalTime time;

    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate date;
    Long filmId;
    Long hallId;
    int priceForChild;
    int price;
}
