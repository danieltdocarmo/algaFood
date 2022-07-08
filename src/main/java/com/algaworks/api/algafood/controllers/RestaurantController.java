package com.algaworks.api.algafood.controllers;

import com.algaworks.api.algafood.domain.dtos.DTORestaurant;
import com.algaworks.api.algafood.domain.model.Restaurant;
import com.algaworks.api.algafood.domain.service.restaurant.CreateRestaurantService;
import com.algaworks.api.algafood.domain.service.restaurant.ListRestaurantService;
import com.algaworks.api.algafood.domain.service.restaurant.UpdateRestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    ListRestaurantService listRestaurantService;

    @Autowired
    CreateRestaurantService createRestaurantService;

    @Autowired
    UpdateRestauranteService updateRestauranteService;

    @GetMapping
    public ResponseEntity<List<Restaurant>> listAll() {
        return ResponseEntity.ok(listRestaurantService.execute());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Restaurant restaurant) {
        try {
            return ResponseEntity.ok(createRestaurantService.execute(restaurant));
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.badRequest().body("Kitchen cannot be found");
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody DTORestaurant restaurant) {
        try {
            return ResponseEntity.ok(updateRestauranteService.execute(id, restaurant));
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(400).body("Restaurant or Kitchen cannot be found");
        }

    }

}
