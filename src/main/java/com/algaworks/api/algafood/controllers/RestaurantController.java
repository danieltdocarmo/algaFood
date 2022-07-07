package com.algaworks.api.algafood.controllers;

import com.algaworks.api.algafood.domain.model.Restaurant;
import com.algaworks.api.algafood.domain.service.CreateRestaurantService;
import com.algaworks.api.algafood.domain.service.ListRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    ListRestaurantService listRestaurantService;

    @Autowired
    CreateRestaurantService createRestaurantService;

    @GetMapping
    public ResponseEntity<List<Restaurant>> listAll() {
        return ResponseEntity.ok(listRestaurantService.execute());
    }

    @PostMapping("{/id}")
    public ResponseEntity<?> create(@RequestBody Restaurant restaurant) {
        try {
            return ResponseEntity.ok(createRestaurantService.execute(restaurant));
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(400).body("Kitchen cannot be found");
        }
    }

}
