package com.algaworks.api.algafood.controllers;

import com.algaworks.api.algafood.domain.dtos.DTORestaurant;
import com.algaworks.api.algafood.domain.model.Restaurant;
import com.algaworks.api.algafood.domain.service.restaurant.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

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

    @Autowired
    FieldUpdateRestaurantService fieldUpdateRestaurantService;

    @Autowired
    DeleteRestaurantService deleteRestaurantService;

    @Autowired
    FindByNameRestaurantService findByNameRestaurantService;

    @GetMapping
    public ResponseEntity<List<Restaurant>> listAll() {
        return ResponseEntity.ok(listRestaurantService.execute());
    }

    @GetMapping("/by-name")
    public ResponseEntity<List<Restaurant>> findByName(String name, String id){
        final var restaurants = findByNameRestaurantService.execute(name, UUID.fromString(id));
        return ResponseEntity.ok(restaurants);
    }

    @PostMapping
    public ResponseEntity<?> create(
        @RequestBody @Valid Restaurant restaurant) {
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

    @PatchMapping("/{id}")
    public ResponseEntity<Restaurant> update(@PathVariable UUID id,@RequestBody Map<String, Object> restaurantFields){
        try {
            final var restaurant = fieldUpdateRestaurantService.execute(id, restaurantFields);
            return ResponseEntity.ok(restaurant);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){
        try {
            deleteRestaurantService.execute(id);
            return ResponseEntity.noContent().build();
        }catch (EmptyResultDataAccessException e){
            return ResponseEntity.notFound().build();
        }
    }
}
