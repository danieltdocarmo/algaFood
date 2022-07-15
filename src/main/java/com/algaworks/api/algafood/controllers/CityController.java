package com.algaworks.api.algafood.controllers;

import com.algaworks.api.algafood.domain.model.City;
import com.algaworks.api.algafood.domain.service.cities.CreateCityService;
import com.algaworks.api.algafood.domain.service.cities.DeleteCityService;
import com.algaworks.api.algafood.domain.service.cities.ListCityService;
import com.algaworks.api.algafood.domain.service.cities.UpdateCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


import static org.springframework.http.ResponseEntity.ok;


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

        return ok(savedCity);
    }

    @GetMapping
    public ResponseEntity<List<City>> list(){
        return ResponseEntity.ok(listCityService.execute());
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> update(@PathVariable UUID id, @RequestBody String name){
        try {
            final var state = updateCityService.execute(id, name);
            return ResponseEntity.ok(state);
        } catch (EmptyResultDataAccessException e){
            return ResponseEntity.notFound().build();
        }


    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        deleteCityService.execute(id);
    }
}
