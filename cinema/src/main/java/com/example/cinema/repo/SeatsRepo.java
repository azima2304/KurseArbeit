package com.example.cinema.repo;


import com.example.cinema.models.entity.Seats;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatsRepo extends JpaRepository<Seats, Long> {

    @Query("SELECT s.hall.id FROM Seats s WHERE s.row = :rowNumber AND s.place = :placeNumber ")
    List<Long> findHallIdByRowAndPlace(@Param("rowNumber") int rowNumber, @Param("placeNumber") int placeNumber);

    @Query("SELECT s FROM Seats s WHERE s.row = :rowNumber AND s.place = :placeNumber and s.hall.id=:idHall")
    Seats findSeatsByRowAndPlace(@Param("rowNumber") int rowNumber, @Param("placeNumber") int placeNumber,  @Param("idHall") Long idHall);

    @Query("SELECT s FROM Seats s WHERE s.hall.id = :hallId")
    List<Seats> findSeatsByHallID(@Param("hallId") Long hallId);

}
