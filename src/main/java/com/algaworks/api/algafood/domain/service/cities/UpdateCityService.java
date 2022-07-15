package com.algaworks.api.algafood.domain.service.cities;

import com.algaworks.api.algafood.domain.model.State;
import com.algaworks.api.algafood.domain.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateCityService {

    @Autowired
    StateRepository stateRepository;
    public State execute(UUID id, String name) {
        final var state = stateRepository.findById(id).orElseThrow(() -> {
            throw new EmptyResultDataAccessException(1);
        });

        state.setName(name);

        return stateRepository.save(state);


    }
}
