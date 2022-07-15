package com.algaworks.api.algafood.domain.service.restaurant;

import com.algaworks.api.algafood.domain.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteRestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    public void execute(UUID id){
        final var restaurant = restaurantRepository.findById(id);

        if(restaurant.isEmpty()){
            throw new EmptyResultDataAccessException(1);
        }

        restaurantRepository.delete(restaurant.get());
    }
}
