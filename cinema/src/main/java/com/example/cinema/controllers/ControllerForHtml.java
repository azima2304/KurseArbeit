package com.example.cinema.controllers;

import com.example.cinema.models.dto.response.CinemaR.CinemaResponse;
import com.example.cinema.models.entity.Session;
import com.example.cinema.service.CinemaService;
import com.example.cinema.service.impl.CinemaServiceImpl;
import com.example.cinema.utils.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.example.cinema.utils.Language.EN;

@Controller
public class ControllerForHtml {
    @Autowired
    CinemaServiceImpl cinemaService;
//
//    @GetMapping("/seatsbooking")
//    public String showSeatsBookingPage() {
//        return "seatsbooking"; // имя файла без расширения
//    }
    @GetMapping("/seatsbooking")
    public String showSeatsBookingPage(Model model) {
        // Добавьте любые атрибуты, которые вы хотите передать на страницу
        model.addAttribute("title", "Seats Booking");
        return "seatsbooking";
    }

    @GetMapping("/cinemas")
    public String showSeatsCinemasPage(Model model) {
        model.addAttribute("title", "Cinemas");
        return "cinemas";
    }
    @GetMapping("/article")
    public String showSessionsPage(Model model, @RequestParam("cinemaId") Long cinemaId, @RequestParam("date") String date) {
        CinemaResponse cinemaResponse = cinemaService.allCinema(cinemaId, EN, date);
        model.addAttribute("cinema", cinemaResponse);
        return "article";
    }
}
