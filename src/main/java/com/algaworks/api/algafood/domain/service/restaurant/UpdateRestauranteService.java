package com.algaworks.api.algafood.domain.service.restaurant;

import com.algaworks.api.algafood.domain.dtos.DTORestaurant;
import com.algaworks.api.algafood.domain.model.Restaurant;
import com.algaworks.api.algafood.domain.repositories.KitchenRepository;
import com.algaworks.api.algafood.domain.repositories.RestaurantRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateRestauranteService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    KitchenRepository kitchenRepository;

    public Restaurant execute(UUID id, DTORestaurant dtoRestaurant) {
        final var findedRestaurant = restaurantRepository.findById(id);

        final var findedKitchen = kitchenRepository.findById(dtoRestaurant.getKitchen().getId());

        if (findedKitchen == null || findedRestaurant == null) {
            throw new EmptyResultDataAccessException(1);
        }

        BeanUtils.copyProperties(dtoRestaurant, findedRestaurant, "id");

        return restaurantRepository.save(findedRestaurant);
    }
}
