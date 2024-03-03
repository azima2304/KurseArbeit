package com.example.cinema.models.entity;

import com.example.cinema.base.BaseEntity;
import com.example.cinema.models.enums.HallType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "hall")
public class Hall extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    String name;

    @Enumerated(value = EnumType.STRING)
    HallType hallType;

    private int rows;
    private int places;

    @ManyToOne
    @JoinColumn(name = "id_cinema")
    Cinema cinema;

}
