package com.example.cinema.repo;

import com.example.cinema.base.BaseRepo;
import com.example.cinema.models.entity.Seats;
import com.example.cinema.models.entity.Session;
import com.example.cinema.models.entity.SessionSeats;
import feign.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionSeatsRepo extends BaseRepo<SessionSeats> {
    @Query("SELECT ss FROM SessionSeats ss WHERE ss.session = :session AND ss.seat = :seat")
    SessionSeats findBySessionAndSeat(@Param("session") Session session, @Param("seat") Seats seat);

}
