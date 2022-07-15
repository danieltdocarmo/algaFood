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
public class PaymentForm {

    @EqualsAndHashCode.Include
    @Id
    @Column(nullable = false)
    private UUID id;

    @Column
    private String description;
}
