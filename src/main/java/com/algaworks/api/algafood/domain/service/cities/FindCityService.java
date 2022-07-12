package com.algaworks.api.algafood.domain.service.cities;

import com.algaworks.api.algafood.domain.model.City;
import com.algaworks.api.algafood.domain.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FindCityService {

    @Autowired
    CityRepository cityRepository;

    public City execute(UUID id) {
        final var findedCity = cityRepository.findById(id);

        if(findedCity == null){
            throw new EmptyResultDataAccessException(1);
        }

        return findedCity;
    }
}
