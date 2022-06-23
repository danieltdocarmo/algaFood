package com.algaworks.api.algafood.domain.repositories;

import com.algaworks.api.algafood.domain.model.Kitchen;

import java.util.List;
import java.util.UUID;

public interface KitchenRepository {

     List<Kitchen> listAll();

     Kitchen save(Kitchen kitchen);

     void remove(UUID id);

     Kitchen findById(UUID id);
}
