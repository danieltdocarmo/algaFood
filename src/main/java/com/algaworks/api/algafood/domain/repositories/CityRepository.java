package com.algaworks.api.algafood.domain.repositories;

import com.algaworks.api.algafood.domain.model.City;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CityRepository extends JpaRepository<City, UUID> {

    public List<City> findByName(String name);
}
