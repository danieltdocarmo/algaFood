package com.algaworks.api.algafood.domain.service.cities;

import com.algaworks.api.algafood.domain.dtos.DTOCity;
import com.algaworks.api.algafood.domain.model.City;
import com.algaworks.api.algafood.domain.repositories.CityRepository;
import com.algaworks.api.algafood.domain.repositories.StateRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateCityService {

    @Autowired
    CityRepository cityRepository;

    @Autowired
    StateRepository stateRepository;

    public City execute(UUID id, DTOCity city) {
        final var foundCity = cityRepository.findById(id);
        final var foundState = cityRepository.findById(city.getState().getId());

        if(foundCity.isEmpty() || foundState.isEmpty()){
            throw new EmptyResultDataAccessException(1);
        }

        BeanUtils.copyProperties(city, foundCity.get(), "id");

        return cityRepository.save(foundCity.get());


    }
}
