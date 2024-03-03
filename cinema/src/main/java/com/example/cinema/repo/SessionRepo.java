package com.example.cinema.repo;

import com.example.cinema.base.BaseRepo;
import com.example.cinema.models.entity.Films;
import com.example.cinema.models.entity.Hall;
import com.example.cinema.models.entity.Session;
import feign.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface SessionRepo extends BaseRepo<Session> {

//    @Query(value = "SELECT name from films where id=:filmId", nativeQuery = true)
//    String findFillmById(Long filmId);

//    @Query("SELECT s.film.name, s.hall.cinema.name, s.hall.name, s.time, s.date, s.price, s.priceForChild FROM Session s WHERE s.film.id = :filmId")
//    List<Object[]> findSessionsByFilmId(@Param("filmId") Long filmId);


    @Query("SELECT s.hall.id FROM Session s WHERE s.id = :idSession")
    Long findHallIdBySessionId(@Param("idSession") Long idSession);


    @Query("SELECT s FROM Session s WHERE s.id = :idSession")
    Session findSessionById(@Param("idSession") Long idSession);

    @Query("SELECT s FROM Session s WHERE s.hall = :hall AND s.date = :date")
    List<Session> findByHallAndDate(Hall hall, LocalDate date);


    @Query("SELECT s FROM Session s WHERE s.hall.id = :hallId")
    List<Session> findByHallId(Long hallId);

    @Query("SELECT s FROM Session s WHERE s.film.id = :filmId")
    List<Session> sessionsByFilmId(@Param ("filmId") Long filmId);

}
