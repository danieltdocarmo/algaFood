package com.algaworks.api.algafood.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.api.algafood.domain.repositories.RestaurantRepository;

@RestController
@RequestMapping("/tests")
public class TestController {
    
    @Autowired
    RestaurantRepository restaurantRepository;

    @GetMapping
    public void test(){
      
    
    }
}
