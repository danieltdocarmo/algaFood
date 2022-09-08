package com.algaworks.api.algafood.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.EqualsAndHashCode;

@Entity
@Table
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserOrder {

    @Id
    @EqualsAndHashCode.Include
    private UUID id;

    @Column
    private BigDecimal subTotal;

    @Column
    private BigDecimal total;

    @UpdateTimestamp
    @Column(nullable = false, columnDefinition = "timestamp")
    private LocalDateTime updated_at;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "timestamp")
    private LocalDateTime created_at;

    @Column
    private LocalDateTime canceled_at;

    @Column
    private LocalDateTime delivered_at;

    @Column
    private OrderStatus status;
    
}
