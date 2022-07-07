package com.algaworks.api.algafood.controllers;

import com.algaworks.api.algafood.domain.model.Kitchen;
import com.algaworks.api.algafood.domain.service.*;
import com.algaworks.api.algafood.infrastructure.repositories.KitchenRepositoryImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Transactional
@RestController
@RequestMapping("/kitchen")
public class KitchenController {

    @Autowired
    CreateKitchenService createKitchenService;

    @Autowired
    DeleteKitchenService deleteKitchenService;

    @Autowired
    UpdateKitchenService updateKitchenService;


    @Autowired
    FindKitchenService findKitchenService;

    @Autowired
    ListKitchensService listKitchensService;

    @GetMapping
    public List<Kitchen> listAll() {
        return listKitchensService.execute();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kitchen> find(@PathVariable UUID id) {

        try {
            var findedKitchen = findKitchenService.execute(id);
            return ResponseEntity.ok(findedKitchen);
        }catch (EmptyResultDataAccessException e){
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Kitchen> create(@RequestBody Kitchen kitchen) {
        final var createdKitchen = createKitchenService.execute(kitchen);

        if (createdKitchen != null) {
            return ResponseEntity.ok(createdKitchen);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Kitchen> update(@PathVariable UUID id, @RequestBody String name) {
        try {
            final var updatedKitchen = updateKitchenService.execute(id, name);
            return ResponseEntity.ok(updatedKitchen);
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity remove(@PathVariable UUID id) {
        try {
            deleteKitchenService.execute(id);
            return ResponseEntity.noContent().build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }

    }


}
