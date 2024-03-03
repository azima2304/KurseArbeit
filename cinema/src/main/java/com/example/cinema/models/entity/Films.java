package com.example.cinema.models.entity;

import com.example.cinema.base.BaseEntity;
import com.example.cinema.models.enums.Genre;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "films")
public class Films extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    String name;
    String logo;
    int year;
    @Enumerated(value = EnumType.STRING)
    Genre genre;
    int duration;
    String description;
    String country;
    String trailer;
    int age;



}
