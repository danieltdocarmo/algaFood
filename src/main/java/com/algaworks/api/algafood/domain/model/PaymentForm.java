package com.algaworks.api.algafood.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PaymentForm {

    @EqualsAndHashCode.Include
    @Id
    @Column(nullable = false)
    private int id;

    @Column
    private String description;
}
