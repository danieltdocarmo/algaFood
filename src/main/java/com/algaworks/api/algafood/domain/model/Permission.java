package com.algaworks.api.algafood.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@Table
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Permission {

    @EqualsAndHashCode.Include
    @Id
    @Column
    private UUID id;

    @Column
    private String name;

    @Column
    private String description;
}
