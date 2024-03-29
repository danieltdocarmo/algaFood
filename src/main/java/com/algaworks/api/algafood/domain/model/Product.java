package com.algaworks.api.algafood.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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

    @UpdateTimestamp
    @Column(nullable = false, columnDefinition = "timestamp")
    private LocalDateTime updated_at;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "timestamp")
    private LocalDateTime created_at;
}
