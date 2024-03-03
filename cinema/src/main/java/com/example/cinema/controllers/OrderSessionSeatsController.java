package com.example.cinema.controllers;


import com.example.cinema.utils.Language;
import com.example.cinema.models.dto.request.OrderSessionSeatsCreateRequest;
import com.example.cinema.service.OrderSessionSeatsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/orderSession")
@Api(tags = "Booking")
public class OrderSessionSeatsController {

    public OrderSessionSeatsController(OrderSessionSeatsService service) {
        this.service = service;
    }
    private final OrderSessionSeatsService service;

    @PostMapping("/create")
    @ApiOperation("Бронирование места")
    ResponseEntity<?> createOrderSeatsSession(@RequestBody OrderSessionSeatsCreateRequest request, Language language){
        try {
            return new ResponseEntity<>(service.create(request, language), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}
