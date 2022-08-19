package com.algaworks.api.algafood.repositories;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.algaworks.api.algafood.domain.repositories.CustomJpaRepository;


public class CustomJpaRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements CustomJpaRepository<T, ID> {

    private EntityManager em;

    public CustomJpaRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager){
        super(entityInformation, entityManager);
        this.em = entityManager;
    }

    @Override
    public Optional<T> findFirst() {
         var jqpl = new StringBuilder();

         jqpl.append("from " + getDomainClass().getName());

         final var entity = em.createQuery(jqpl.toString(), getDomainClass())
         .setMaxResults(1)
         .getSingleResult();

        return Optional.ofNullable(entity);
    }
    
}
