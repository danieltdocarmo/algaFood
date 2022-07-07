package com.algaworks.api.algafood.domain.service;

import com.algaworks.api.algafood.domain.repositories.KitchenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DeleteKitchenService {

    @Autowired
    KitchenRepository kitchenRepository;

    public void execute(UUID id){

        kitchenRepository.remove(id);

    }
}
