package com.algaworks.api.algafood.domain.service.state;

import com.algaworks.api.algafood.domain.model.State;
import com.algaworks.api.algafood.domain.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateStateService {

    @Autowired
    StateRepository stateRepository;

    public State execute(State state) {
        return stateRepository.save(state);
    }
}
