package com.algaworks.api.algafood.domain.service.kitchen;

import com.algaworks.api.algafood.domain.model.Kitchen;
import com.algaworks.api.algafood.domain.repositories.KitchenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class FindKitchenService {

    @Autowired
    KitchenRepository kitchenRepository;

    public Optional<Kitchen> execute(UUID id){
        return kitchenRepository.findById(id);
    }
}
