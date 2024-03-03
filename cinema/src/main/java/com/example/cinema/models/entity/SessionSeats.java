package com.example.cinema.models.entity;


import com.example.cinema.base.BaseEntity;
import com.example.cinema.models.enums.PriceType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "session_seats")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SessionSeats extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;



    @ManyToOne
    @JoinColumn(name = "id_seats")
    Seats seat;

    @ManyToOne
    @JoinColumn(name = "id_session")
    Session session;

    @Enumerated(EnumType.STRING)
    PriceType priceType;

//    @Override
//    protected void onCreate() {
//        super.onCreate();
//        priceType=PriceType.ADULTS;
//    }
}
