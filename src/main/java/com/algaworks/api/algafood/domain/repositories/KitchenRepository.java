package com.algaworks.api.algafood.domain.repositories;

import com.algaworks.api.algafood.domain.model.Kitchen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface KitchenRepository extends JpaRepository<Kitchen, UUID> {

     List<Kitchen> findByNameContaining(String name);
}
