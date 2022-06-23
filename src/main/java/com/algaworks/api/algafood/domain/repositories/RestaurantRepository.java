package com.algaworks.api.algafood.domain.repositories;

import com.algaworks.api.algafood.domain.model.Restaurant;

import java.util.List;
import java.util.UUID;

public interface RestaurantRepository {

    List<Restaurant> listAll();

    Restaurant save(Restaurant restaurant);

    void remove(UUID id);

    Restaurant findById(UUID id);
}
