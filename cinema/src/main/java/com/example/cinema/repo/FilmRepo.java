package com.example.cinema.repo;


import com.example.cinema.base.BaseRepo;
import com.example.cinema.models.dto.response.FilmR.FilmsResponse;
import com.example.cinema.models.entity.Films;
import feign.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

@Repository
public interface FilmRepo extends BaseRepo<Films> {

    @Query("SELECT f from Films f where f.id=:idFilm")
    Films findByFilmId(@Param("idFilm")Long idFilm);
    @Query("SELECT  f.logo as logo, f.name as name, f.age as age from Films f ")
    Page<FilmsResponse> getAllFilms(Pageable pageable);
    @Query(value = "SELECT f FROM Films f JOIN Session s ON f.id = s.film.id WHERE f.id = :idFilm AND s.date = :sDate")
    Films findByFilmIdAndDate(@Param("idFilm") Long idFilm, @Param("sDate") LocalDate sDate);


//    @Query(value = "SELECT f.* " +
//            "FROM films f " +
//            "JOIN session s ON f.id = s.id_film " +
//            "WHERE f.id = :idFilm AND s.date = CAST(:sDate AS DATE)", nativeQuery = true)
//    Films findByFilmIdAndDate(@Param("idFilm") Long idFilm, @Param("sDate") LocalDate sDate);

}
