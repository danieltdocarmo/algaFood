package com.algaworks.api.algafood.domain.repositories;

import com.algaworks.api.algafood.domain.model.Restaurant;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RestaurantRepository extends CustomJpaRepository<Restaurant, UUID>, CustonsRestaurantRepository, JpaSpecificationExecutor<Restaurant> {

    @Query("from Restaurant where name = :name and kitchen.id = :id")
    public List<Restaurant> findByNameAndId(String name, String id);

}
