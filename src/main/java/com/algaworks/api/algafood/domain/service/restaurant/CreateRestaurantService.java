package com.algaworks.api.algafood.domain.service.restaurant;

import com.algaworks.api.algafood.domain.model.Restaurant;
import com.algaworks.api.algafood.domain.repositories.RestaurantRepository;
import com.algaworks.api.algafood.domain.service.kitchen.FindKitchenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CreateRestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    FindKitchenService findKitchenService;

    public Restaurant execute(Restaurant restaurant){

        final var findedKitchen = findKitchenService.execute(restaurant.getKitchen().getId());

        if (findedKitchen == null) {
            throw new EmptyResultDataAccessException(1);
        }

        return restaurantRepository.save(restaurant);

    }
}
