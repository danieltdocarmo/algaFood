package com.algaworks.api.algafood.repositories;

import com.algaworks.api.algafood.domain.model.Restaurant;
import com.algaworks.api.algafood.domain.repositories.CustonsRestaurantRepository;
import com.algaworks.api.algafood.domain.repositories.RestaurantRepository;
import com.algaworks.api.algafood.repositories.specs.RestaurantSpecs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class RestaurantRepositoryImpl implements CustonsRestaurantRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired @Lazy
    RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> findByNameAndTaxs(String name, Double initialTax, Double finalTax){

        final var criteriaBuilder = entityManager.getCriteriaBuilder();

        final var criteriaQuery = criteriaBuilder.createQuery(Restaurant.class);

        final var rootRestaurant = criteriaQuery.from(Restaurant.class);
        final var arrayList = new ArrayList<Predicate>();

        if(StringUtils.hasText(name)){
            arrayList.add(criteriaBuilder.like(rootRestaurant.get("name"), "%" + name + "%"));
        }

        if(Objects.isNull(initialTax) && Objects.isNull(finalTax)){
            arrayList.add(criteriaBuilder.between(rootRestaurant.get("tax"), initialTax, finalTax));
        }

        criteriaQuery.where(arrayList.toArray(new Predicate[0]));

        final var  query = entityManager.createQuery(criteriaQuery);

        return query.getResultList();
    }

    @Override
    public List<Restaurant> findWithNameAndFreeTax(String name) {
        final var restaurants = restaurantRepository.findAll(RestaurantSpecs.withFreeTax().and(RestaurantSpecs.withNameLike(name)));
        return  restaurants;
    }
}
