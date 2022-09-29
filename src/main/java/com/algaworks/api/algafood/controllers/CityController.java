package com.algaworks.api.algafood.controllers;

import com.algaworks.api.algafood.domain.dtos.DTOCity;
import com.algaworks.api.algafood.domain.model.City;
import com.algaworks.api.algafood.domain.service.cities.CreateCityService;
import com.algaworks.api.algafood.domain.service.cities.DeleteCityService;
import com.algaworks.api.algafood.domain.service.cities.ListCityService;
import com.algaworks.api.algafood.domain.service.cities.UpdateCityService;
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

    @Autowired
    ListCityService listCityService;

    @Autowired
    DeleteCityService deleteCityService;

    @Autowired
    UpdateCityService updateCityService;


    @PostMapping
    public ResponseEntity<City> create(@RequestBody City city){
        final var savedCity = createCityService.execute(city);

        return ResponseEntity.ok(savedCity);
    }

    @GetMapping
    public ResponseEntity<List<City>> list(){
        return ResponseEntity.ok(listCityService.execute());
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> update(@PathVariable UUID id, @RequestBody DTOCity city){
        final var foundCity = updateCityService.execute(id, city);

        return ResponseEntity.ok(foundCity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        deleteCityService.execute(id);
    }

}
