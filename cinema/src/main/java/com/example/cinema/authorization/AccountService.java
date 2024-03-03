package com.example.cinema.authorization;

import com.example.cinema.models.dto.response.Response;

public interface AccountService {
    Response auth(AuthRequest request);
}
