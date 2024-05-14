package com.example.cinema.controllers;

import com.example.cinema.authorization.AccountService;
import com.example.cinema.authorization.AuthRequest;
import com.example.cinema.models.dto.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Api(tags = "Authorization")
public class AuthorController {

    @Autowired
    private AccountService accountService;


    @ApiOperation("Auth")
    @PostMapping("/login")
    public ResponseEntity<Response> login(@RequestBody AuthRequest request) {
        try {
            return new ResponseEntity<>(accountService.auth(request), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
