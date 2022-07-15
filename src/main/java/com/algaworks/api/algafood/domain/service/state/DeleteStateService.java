package com.algaworks.api.algafood.domain.service.state;

import com.algaworks.api.algafood.domain.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteStateService {

    @Autowired
    StateRepository stateRepository;

    public void execute(UUID id){
        final var state = stateRepository.findById(id).orElseThrow(() -> {
            throw new EmptyResultDataAccessException(1);
        });

        stateRepository.delete(state);
    }
}
