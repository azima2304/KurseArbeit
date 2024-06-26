package com.example.cinema.models.dto.response.CinemaR;
import com.example.cinema.models.dto.response.CinemaR.SeatsResponse;import com.example.cinema.models.enums.Genre;
import com.example.cinema.models.enums.PriceType;import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;import java.time.LocalTime;
import java.util.List;
@Getter@Setter
@NoArgsConstructor@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)public class SessionResponse {
    Long id;    String filmName;
    LocalDate localDate;    LocalTime localTime;
    int price;    int priceForChildren;
    String logo;    int year;
    Genre genre;    int duration;
    String description;    String country;
    int age;
    List<SeatsResponse> seatsResponse;
    @Override    public String toString() {
        return "SessionResponse{" +
                "id=" + id +
                ", filmName='" + filmName + '\'' +
                ", localDate=" + localDate +
                ", localTime=" + localTime +
                ", price=" + price +
                ", priceForChildren=" + priceForChildren +
                ", logo='" + logo + '\'' +
                ", year=" + year +
                ", genre=" + genre +
                ", duration=" + duration +
                ", description='" + description + '\'' +
                ", country='" + country + '\'' +
                ", age=" + age +
                ", seatsResponse=" + seatsResponse +
                '}';
    }
}