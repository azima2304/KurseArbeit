package com.example.cinema.controllers;


import com.example.cinema.utils.Language;
import com.example.cinema.models.dto.request.SessionCreateRequest;
import com.example.cinema.service.SessionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/session")
@Api(tags = "Session")
public class SessionController {

    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }


    @PostMapping("/create")
    @ApiOperation("Создание сеанса")
    ResponseEntity<?> createHall(@RequestBody SessionCreateRequest request, @RequestParam Language language){
        try {
            return new ResponseEntity<>(sessionService.createSession(request, language), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


}
