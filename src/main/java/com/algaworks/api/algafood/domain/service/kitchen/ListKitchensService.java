package com.algaworks.api.algafood.domain.service.kitchen;

import com.algaworks.api.algafood.domain.model.Kitchen;
import com.algaworks.api.algafood.domain.repositories.KitchenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListKitchensService {

    @Autowired
    KitchenRepository kitchenRepository;

    public List<Kitchen> execute(){
        return kitchenRepository.listAll();
    }
}
