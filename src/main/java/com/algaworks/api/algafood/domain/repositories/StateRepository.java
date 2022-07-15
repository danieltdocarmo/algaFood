package com.algaworks.api.algafood.domain.repositories;

import com.algaworks.api.algafood.domain.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StateRepository extends JpaRepository<State, UUID> {

}
