package com.algaworks.api.algafood.domain.service.restaurant;

import com.algaworks.api.algafood.domain.exceptions.AlreadyExistException;
import com.algaworks.api.algafood.domain.model.Restaurant;
import com.algaworks.api.algafood.domain.repositories.RestaurantRepository;
import com.algaworks.api.algafood.domain.service.kitchen.FindKitchenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateRestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    FindKitchenService findKitchenService;

    public Restaurant execute(Restaurant restaurant){

        final var foundRestaurant = findKitchenService.execute(restaurant.getKitchen().getId());

        if (foundRestaurant.isPresent()) {
            throw new AlreadyExistException("Kitchen already exist");
        }

        return restaurantRepository.save(restaurant);

    }
}
