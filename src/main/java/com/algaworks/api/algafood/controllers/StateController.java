package com.algaworks.api.algafood.controllers;

import com.algaworks.api.algafood.domain.model.State;
import com.algaworks.api.algafood.domain.service.state.CreateStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/states")
public class StateController {

    @Autowired
    CreateStateService createStateService;

    @PostMapping
    public ResponseEntity<State> create(@RequestBody State state) {
       final var savedState = createStateService.execute(state);

       return ResponseEntity.ok(savedState);
    }
}
