package com.algaworks.api.algafood.domain.repositories;

import com.algaworks.api.algafood.domain.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.naming.spi.ResolveResult;
import java.util.List;
import java.util.UUID;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, UUID>, CustonsRestaurantRepository {

    @Query("from Restaurant where name = :name and kitchen.id = :id")
    public List<Restaurant> findByNameAndId(String name, String id);

}
