package com.algaworks.api.algafood.domain.service.cities;

import com.algaworks.api.algafood.domain.exceptions.EntityCityNotFoundException;
import com.algaworks.api.algafood.domain.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteCityService {

    @Autowired
    CityRepository cityRepository;

    public void execute(UUID id){
        final var foundCity = cityRepository.findById(id);

        if(foundCity.isEmpty()){
            throw new EntityCityNotFoundException("Entidade cidade não foi encontrada");
        }

        cityRepository.delete(foundCity.get());
    }
}
