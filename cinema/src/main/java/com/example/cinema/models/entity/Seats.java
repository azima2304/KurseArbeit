package com.example.cinema.models.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "seats")
public class Seats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int row;
    private int place;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;

    boolean isBooked;

}