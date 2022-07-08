package com.algaworks.api.algafood.domain.service.kitchen;

import com.algaworks.api.algafood.domain.model.Kitchen;
import com.algaworks.api.algafood.domain.repositories.KitchenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FindKitchenService {

    @Autowired
    KitchenRepository kitchenRepository;

    public Kitchen execute(UUID id){
        final var kitchen = kitchenRepository.findById(id);

        if(kitchen == null){
            throw new EmptyResultDataAccessException(1);
        }else{
            return kitchen;
        }
    }
}
