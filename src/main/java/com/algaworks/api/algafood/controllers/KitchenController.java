package com.algaworks.api.algafood.controllers;

import com.algaworks.api.algafood.domain.model.Kitchen;
import com.algaworks.api.algafood.domain.service.kitchen.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

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

    @Autowired
    FindByNameKitchenService findByNameService;

    String NOT_FOUND_MESSAGE = "ENTIDADE NAO ENCONTRADA";

    @GetMapping
    public List<Kitchen> listAll() {
        return listKitchensService.execute();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kitchen> findById(@PathVariable UUID id) {
        var foundKitchen = findKitchenService.execute(id).orElseThrow(() -> {
            throw new EntityNotFoundException(NOT_FOUND_MESSAGE);}
        );

        return ResponseEntity.ok(foundKitchen);
    }

    @GetMapping({"/by-name"})
    @RequestMapping(value = "/name", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Kitchen>> findByName(@RequestParam(value = "name") String name) {
        return ResponseEntity.ok(
                findByNameService.execute(name)
        );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Kitchen> create(@RequestBody @Valid Kitchen kitchen) {
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
    public ResponseEntity<?> remove(@PathVariable UUID id) {
        try {
            deleteKitchenService.execute(id);
            return ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }
}