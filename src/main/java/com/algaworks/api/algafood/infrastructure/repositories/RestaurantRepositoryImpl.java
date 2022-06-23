package com.algaworks.api.algafood.infrastructure.repositories;

import com.algaworks.api.algafood.domain.model.Restaurant;
import com.algaworks.api.algafood.domain.repositories.RestaurantRepository;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class RestaurantRepositoryImpl implements RestaurantRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Restaurant> listAll() {
        return entityManager.createQuery("from restaurant").getResultList();
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        return entityManager.merge(restaurant);
    }

    @Override
    public void remove(UUID id) {
        var restaurant = this.findById(id);
        entityManager.remove(restaurant);
    }

    @Override
    public Restaurant findById(UUID id) {
        return entityManager.find(Restaurant.class, id);
    }


}
