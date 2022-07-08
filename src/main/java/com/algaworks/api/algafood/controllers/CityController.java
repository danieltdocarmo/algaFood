package com.algaworks.api.algafood.controllers;

import com.algaworks.api.algafood.domain.model.City;
import com.algaworks.api.algafood.domain.repositories.CityRepository;
import com.algaworks.api.algafood.domain.repositories.StateRepository;
import com.algaworks.api.algafood.domain.service.cities.CreateCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    CreateCityService createCityService;


    @PostMapping
    public ResponseEntity<City> create(@RequestBody City city){
        final var savedCity = createCityService.execute(city);

        return ResponseEntity.ok(savedCity);
    }
}
