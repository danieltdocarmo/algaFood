package com.algaworks.api.algafood.infrastructure.repositories;

import com.algaworks.api.algafood.domain.model.City;
import com.algaworks.api.algafood.domain.repositories.CityRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Repository
public class CityRepositoryImpl implements CityRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public City save(City city) {
        return entityManager.merge(city);
    }

    @Override
    public List list() {
        return entityManager.createQuery("select from City").getResultList();
    }

    @Override
    public City findById(UUID id){
        return entityManager.find(City.class, id);
    }
    @Override
    public void remove(UUID id) {
        entityManager.remove(this.findById(id));
    }


}
