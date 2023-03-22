package com.algaworks.api.algafood.domain.service.kitchen;

import com.algaworks.api.algafood.domain.repositories.KitchenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.UUID;

@Component
public class DeleteKitchenService {

    @Autowired
    KitchenRepository kitchenRepository;

    @Transactional
    public void execute(UUID id){

        final var kitchen = kitchenRepository.findById(id);

        if(kitchen.isEmpty()){
            throw new EmptyResultDataAccessException(1);
        }
        
        kitchenRepository.delete(kitchen.get());

    }
}
