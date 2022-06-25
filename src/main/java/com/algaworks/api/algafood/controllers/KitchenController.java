package com.algaworks.api.algafood.controllers;

import com.algaworks.api.algafood.domain.model.Kitchen;
import com.algaworks.api.algafood.infrastructure.repositories.KitchenRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kitchen")
public class KitchenController {

    @Autowired
    KitchenRepositoryImpl kitchenRepository;

    @GetMapping
    public List<Kitchen> listAll(){
        return kitchenRepository.listAll();
    }
}
