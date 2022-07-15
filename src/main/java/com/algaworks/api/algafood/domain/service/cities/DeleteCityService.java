package com.algaworks.api.algafood.domain.service.cities;

import com.algaworks.api.algafood.domain.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteCityService {

    @Autowired
    CityRepository cityRepository;

    public void execute(UUID id){
        final var findedCity = cityRepository.findById(id);

        if(findedCity.isEmpty()){
            throw new EmptyResultDataAccessException(1);
        }

        cityRepository.delete(findedCity.get());
    }
}
