package com.algaworks.api.algafood.domain.service.cities;

import com.algaworks.api.algafood.domain.model.City;
import com.algaworks.api.algafood.domain.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListCityService {

    @Autowired
    CityRepository cityRepository;

    public List<City> execute(){
        return cityRepository.findAll();
    }
}
