package com.algaworks.api.algafood.domain.service.restaurant;

import com.algaworks.api.algafood.domain.model.Restaurant;
import com.algaworks.api.algafood.domain.repositories.RestaurantRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.util.Map;
import java.util.UUID;

@Service
public class FieldUpdateRestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    public Restaurant execute(UUID id, Map<String, Object> restaurant) {
        final var foundRestaurant = restaurantRepository.findById(id);
        
        if (foundRestaurant.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }
        
        final var convertedRestaurant = new ObjectMapper().convertValue(restaurant, Restaurant.class);
        
        restaurant.forEach((name, value) -> {
            final var field = ReflectionUtils.findField(Restaurant.class, name);
            if(field == null){
                throw new NullPointerException();
            }
            field.setAccessible(true);
            final var fieldValue = ReflectionUtils.getField(field, convertedRestaurant);
            ReflectionUtils.setField(field, foundRestaurant.get(), fieldValue);
        });
            return restaurantRepository.save(foundRestaurant.get());
    }
}
