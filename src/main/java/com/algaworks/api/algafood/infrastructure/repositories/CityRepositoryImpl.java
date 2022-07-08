package com.algaworks.api.algafood.infrastructure.repositories;

import com.algaworks.api.algafood.domain.model.City;
import com.algaworks.api.algafood.domain.repositories.CityRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class CityRepositoryImpl implements CityRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public City save(City city) {
        return entityManager.merge(city);
    }
}
