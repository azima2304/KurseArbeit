package com.example.cinema.models.entity;


import com.example.cinema.base.BaseEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cinema")
public class Cinema extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    String logo;
    String name;
    String description;
    String address;

    @Column(nullable = false)
    String username;

    @Column(nullable = false)
    String password;

}
