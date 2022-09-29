package com.algaworks.api.algafood.domain.service.restaurant;

import com.algaworks.api.algafood.domain.exceptions.AlreadyExistException;
import com.algaworks.api.algafood.domain.model.Restaurant;
import com.algaworks.api.algafood.domain.repositories.RestaurantRepository;
import com.algaworks.api.algafood.domain.service.kitchen.FindKitchenService;

import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateRestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    FindKitchenService findKitchenService;

    public Restaurant execute(Restaurant restaurant){
        final var foundRestaurant = restaurantRepository.findByName(restaurant.getName());

        final var foundKitchen = findKitchenService.execute(restaurant.getKitchen().getId());

        if (foundRestaurant == null) {
            throw new AlreadyExistException("Restaurant already exist");
        }

        if (foundKitchen.isEmpty()) {
            throw new EntityNotFoundException();
        }

        restaurant.setId(UUID.randomUUID());
        
        return restaurantRepository.save(restaurant);

    }
}
