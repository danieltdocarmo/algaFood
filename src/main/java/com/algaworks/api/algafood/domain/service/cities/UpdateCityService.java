package com.algaworks.api.algafood.domain.service.cities;

import com.algaworks.api.algafood.domain.dtos.DTOCity;
import com.algaworks.api.algafood.domain.exceptions.EntityCityNotFoundException;
import com.algaworks.api.algafood.domain.exceptions.EntityNotFoundBadRequestException;
import com.algaworks.api.algafood.domain.exceptions.EntityNotFoundException;
import com.algaworks.api.algafood.domain.exceptions.EntityStateNotFoundException;
import com.algaworks.api.algafood.domain.model.City;
import com.algaworks.api.algafood.domain.repositories.CityRepository;
import com.algaworks.api.algafood.domain.repositories.StateRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
        final var foundState = stateRepository.findById(city.getStateId());

        if(foundCity.isEmpty()){
            throw new EntityCityNotFoundException("Entidade nao foi encontrada");
        }

        if(foundState.isEmpty()){
            throw new EntityStateNotFoundException("Entidade nao foi encontrada");
        }

        BeanUtils.copyProperties(city, foundCity.get(), "id");
        foundCity.get().setState(foundState.get());

        return cityRepository.save(foundCity.get());

    }
}
