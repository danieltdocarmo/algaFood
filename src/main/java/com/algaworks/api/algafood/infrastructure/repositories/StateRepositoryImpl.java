package com.algaworks.api.algafood.infrastructure.repositories;

import com.algaworks.api.algafood.domain.model.State;
import com.algaworks.api.algafood.domain.repositories.StateRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class StateRepositoryImpl implements StateRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public State save(State state) {
        return entityManager.merge(state);
    }
}
