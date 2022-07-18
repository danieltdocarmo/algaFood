package com.algaworks.api.algafood.repositories;

import com.algaworks.api.algafood.domain.model.Restaurant;
import com.algaworks.api.algafood.domain.repositories.CustonsRestaurantRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RestaurantRepositoryImpl implements CustonsRestaurantRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Restaurant> findByNameAndTaxs(String name, Double initialTax, Double finalTax){
        final var jpql = "from Restaurant where name like :name" +
                "and deliveryTax between :initialTax and :finalTax";

        return entityManager.createQuery(jpql, Restaurant.class)
                .setParameter("name", "%" + name + "%")
                .setParameter("initialTax", initialTax)
                .setParameter("finalTax", finalTax)
                .getResultList();
    }
}
