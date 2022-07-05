package com.algaworks.api.algafood.controllers;

import com.algaworks.api.algafood.domain.model.Kitchen;
import com.algaworks.api.algafood.infrastructure.repositories.KitchenRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/kitchen")
public class KitchenController {

    @Autowired
    KitchenRepositoryImpl kitchenRepository;

    @GetMapping
    public List<Kitchen> listAll(){
        return kitchenRepository.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kitchen> list(@PathVariable UUID id){
       var kitchen = kitchenRepository.findById(id);

       if(kitchen != null){
           return ResponseEntity.ok(kitchen);
       }else{
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
           // .notFound().build();
       }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Kitchen kitchen){
        kitchenRepository.save(kitchen);
    }

}
