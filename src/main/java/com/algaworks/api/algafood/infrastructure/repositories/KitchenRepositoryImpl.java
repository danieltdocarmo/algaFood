package com.algaworks.api.algafood.infrastructure.repositories;

import com.algaworks.api.algafood.domain.model.Kitchen;
import com.algaworks.api.algafood.domain.repositories.KitchenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class KitchenRepositoryImpl implements KitchenRepository {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<Kitchen> listAll() {
        return entityManager.createQuery("from Kitchen", Kitchen.class)
                .getResultList();
    }

    @Override
    public Kitchen save(Kitchen kitchen) {
        return entityManager.merge(kitchen);
    }

    @Override
    public Kitchen findById(UUID id){
        return entityManager.find(Kitchen.class, id);
    }

    @Override
    public void remove(UUID id) {
        final var kitchen = findById(id);

        if(kitchen == null){
            throw new EmptyResultDataAccessException(1);
        }

        entityManager.remove(kitchen);
    }
}
