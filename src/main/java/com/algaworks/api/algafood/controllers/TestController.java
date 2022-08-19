package com.algaworks.api.algafood.controllers;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.api.algafood.domain.model.Restaurant;
import com.algaworks.api.algafood.domain.repositories.RestaurantRepository;

@RestController
@RequestMapping("/tests")
public class TestController {
    
    @Autowired
    RestaurantRepository restaurantRepository;

    @GetMapping
    public ResponseEntity<Restaurant> test(){
        final var restaurant = restaurantRepository.findFirst();
            return ResponseEntity.of(restaurant);
    }
}
