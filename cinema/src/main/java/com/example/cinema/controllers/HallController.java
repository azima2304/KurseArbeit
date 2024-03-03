package com.example.cinema.controllers;


import com.example.cinema.utils.Language;
import com.example.cinema.models.dto.request.HallCreateRequest;
import com.example.cinema.service.HallService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hall")
@Api(tags = "Halls")
public class HallController {

    private  final HallService service;

    public HallController( HallService service) {
        this.service = service;
    }


    @PostMapping("/create")
    @ApiOperation("Создание зала")
    ResponseEntity<?> createHall(@RequestBody HallCreateRequest request, @RequestParam Language language){
        try {
            return new ResponseEntity<>(service.createHall(request, language), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }



}
