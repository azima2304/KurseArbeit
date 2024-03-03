package com.example.cinema.models.entity;

import com.example.cinema.base.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "session")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Session extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    LocalTime time;
    LocalDate date;

    @ManyToOne
    @JoinColumn(name = "id_film")
    Films film;

    @ManyToOne
    @JoinColumn(name = "id_hall")
    Hall hall;

    int priceForChild;
    int price;
}
