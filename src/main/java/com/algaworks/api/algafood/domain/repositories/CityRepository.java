package com.algaworks.api.algafood.domain.repositories;

import com.algaworks.api.algafood.domain.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CityRepository extends JpaRepository<City, UUID> {

}
