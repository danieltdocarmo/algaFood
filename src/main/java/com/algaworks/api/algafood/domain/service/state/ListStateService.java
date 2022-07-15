package com.algaworks.api.algafood.domain.service.state;

import com.algaworks.api.algafood.domain.model.State;
import com.algaworks.api.algafood.domain.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListStateService {

    @Autowired
    StateRepository stateRepository;

    public List<State> execute(){
        return stateRepository.findAll();
    }
}
