package com.algaworks.api.algafood.domain.service.state;

import com.algaworks.api.algafood.domain.model.State;
import com.algaworks.api.algafood.domain.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateStateService {

    @Autowired
    StateRepository stateRepository;

    public State execute(UUID id, String name){
        final var foundState = stateRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));

        foundState.setName(name);

        return stateRepository.save(foundState);
    }
}
