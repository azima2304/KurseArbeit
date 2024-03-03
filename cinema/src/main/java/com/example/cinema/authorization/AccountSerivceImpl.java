package com.example.cinema.authorization;

import com.example.cinema.models.dto.response.Response;
import com.example.cinema.models.entity.Cinema;
import com.example.cinema.service.CinemaService;
import org.springframework.stereotype.Service;

@Service
public class AccountSerivceImpl implements AccountService {
    private final CinemaService cinemaService;

    public AccountSerivceImpl(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @Override
    public Response auth(AuthRequest request) {
        Cinema cinema = cinemaService.findCinemasByUsername(request.getUsername());
        if (cinema == null) {
            return new Response("Кинотеатр с таким именем пользователя не найден!");
        } else {
            String realPassword = cinema.getPassword();
            String password = request.getPassword();
            if (password.equals(realPassword)) {
                return new Response("Успешный вход в аккаунт");
            } else {
                return new Response("Введите правильный пароль!");
            }
        }
    }
}
