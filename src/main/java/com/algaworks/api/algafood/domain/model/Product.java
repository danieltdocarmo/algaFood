package com.algaworks.api.algafood.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {
    
    @EqualsAndHashCode.Include
    @Id
    @Column(nullable = false)
    private UUID id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private BigDecimal price;
    
    @Column
    private Boolean isActive;

    @ManyToOne
    private Restaurant restaurant;
}
