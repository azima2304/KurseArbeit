package com.example.cinema.models.dto.request;


import com.example.cinema.models.enums.PriceType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SeatsRequest {
    int row;
    int place;
    PriceType type;

    @Override
    public String toString() {
        return "SeatsRequest{" +
                "row=" + row +
                ", place=" + place +
                ", type=" + type +
                '}';
    }
}
