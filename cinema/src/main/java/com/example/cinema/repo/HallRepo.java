package com.example.cinema.repo;


import com.example.cinema.base.BaseRepo;
import com.example.cinema.models.entity.Hall;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HallRepo extends BaseRepo<Hall> {
//    @Query(value = "SELECT name, hall_type from hall", nativeQuery = true)
//    List<Object[]> findNameAndHallType();

    @Query("SELECT h FROM Hall h WHERE h.cinema.id = :cinemaId")
    List<Hall> findByCinemaId(Long cinemaId);

}
