package com.algaworks.api.algafood.domain.service.kitchen;

import com.algaworks.api.algafood.domain.model.Kitchen;
import com.algaworks.api.algafood.domain.repositories.KitchenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CreateKitchenService {

    @Autowired
    KitchenRepository kitchenRepository;

    public Kitchen execute(Kitchen kitchen){
      return kitchenRepository.save(kitchen);
    }
}
