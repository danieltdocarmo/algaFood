package com.algaworks.api.algafood.domain.repositories;

import com.algaworks.api.algafood.domain.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RestaurantRepository extends JpaRepository<Restaurant, UUID> {

}
