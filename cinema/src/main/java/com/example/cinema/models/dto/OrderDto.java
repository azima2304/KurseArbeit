package com.example.cinema.models.dto;


import com.example.cinema.base.BaseDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDto extends BaseDto {
    Long id;
    int totalPrice;
    Integer uniqueNumber;

    String clientEmail;
}
