package com.algaworks.api.algafood.infrastructure.repositories;

import com.algaworks.api.algafood.domain.model.Restaurant;
import com.algaworks.api.algafood.domain.repositories.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;
@Repository
public class RestaurantRepositoryImpl implements RestaurantRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Restaurant> listAll() {
        return entityManager.createQuery("from Restaurant").getResultList();
    }

    @Override
    @Transactional
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
