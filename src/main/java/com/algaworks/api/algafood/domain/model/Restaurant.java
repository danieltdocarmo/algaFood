package com.algaworks.api.algafood.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Table
@Entity
public class Restaurant {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column
    private String name;

    @Column(name = "delivery_tax")
    private BigDecimal deliveryTax;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getDeliveryTax() {
        return deliveryTax;
    }

    public void setDeliveryTax(BigDecimal deliveryTax) {
        this.deliveryTax = deliveryTax;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
