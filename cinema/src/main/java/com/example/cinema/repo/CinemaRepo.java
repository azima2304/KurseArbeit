package com.example.cinema.repo;

import com.example.cinema.base.BaseRepo;

import com.example.cinema.models.dto.response.CinemaR.CinemasResponse;
import com.example.cinema.models.dto.response.FilmR.FilmsResponse;
import com.example.cinema.models.entity.Cinema;
import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRepo extends BaseRepo<Cinema> {

    @Query("SELECT c from Cinema c where c.id=:idCinema")
    Cinema findByIdCinema(@Param ("idCinema") Long idCinema);

    @Query("SELECT c.id as id,c.logo as logo, c.name as name, c.address as address from Cinema c ")
    Page<CinemasResponse> getAllCinemas(Pageable pageable);

    Cinema findCinemasByUsername(String username);
}
