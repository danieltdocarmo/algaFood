package com.algaworks.api.algafood.controllers;

import com.algaworks.api.algafood.domain.model.Restaurant;
import com.algaworks.api.algafood.infrastructure.repositories.RestaurantRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantRepositoryImpl restaurantRepository;

    @GetMapping
    public List<Restaurant> listAll(){
        return restaurantRepository.listAll();
    }

}
