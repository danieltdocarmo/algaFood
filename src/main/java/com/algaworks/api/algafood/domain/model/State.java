package com.algaworks.api.algafood.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.UUID;

@Table
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class State {

    @EqualsAndHashCode.Include
    @Id
    @Column(nullable = false)
    private UUID id;

    @Column
    private String name;
}
