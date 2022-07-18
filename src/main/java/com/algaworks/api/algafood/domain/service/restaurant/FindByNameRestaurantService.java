package com.algaworks.api.algafood.domain.service.restaurant;

import com.algaworks.api.algafood.domain.model.Restaurant;
import com.algaworks.api.algafood.domain.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FindByNameRestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    public List<Restaurant> execute(String name, UUID id){

        return restaurantRepository.findByNameAndId(name, id.toString());
    }
}
