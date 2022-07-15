package com.algaworks.api.algafood.domain.service.restaurant;

import com.algaworks.api.algafood.domain.model.Restaurant;
import com.algaworks.api.algafood.domain.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListRestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    public List<Restaurant> execute(){
        return restaurantRepository.findAll();
    }

}
