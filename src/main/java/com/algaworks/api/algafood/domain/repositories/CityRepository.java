package com.algaworks.api.algafood.domain.repositories;

import com.algaworks.api.algafood.domain.model.City;

import java.util.List;
import java.util.UUID;

public interface CityRepository {

    City save(City city);

    List<City> list();

    void remove(UUID id);

    City findById(UUID id);

}
