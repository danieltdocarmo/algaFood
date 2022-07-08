package com.algaworks.api.algafood.domain.service.kitchen;

import com.algaworks.api.algafood.domain.model.Kitchen;
import com.algaworks.api.algafood.domain.repositories.KitchenRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateKitchenService {

    @Autowired
    KitchenRepository kitchenRepository;
    public Kitchen execute(UUID id, String name){
        final var findedKitchen = kitchenRepository.findById(id);

        if (findedKitchen == null) {
            throw new EmptyResultDataAccessException(1);
        }

        BeanUtils.copyProperties(new Kitchen(name), findedKitchen, "id");

        return kitchenRepository.save(findedKitchen);
    }
}
