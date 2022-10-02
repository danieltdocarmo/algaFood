package com.algaworks.api.algafood.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.validation.annotation.Validated;

import com.algaworks.api.algafood.domain.interfaces.Groups;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Table
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Restaurant {

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "id")
    private UUID id;

    @Column
    @NotNull(groups = Groups.CreationRestaurant.class)
    @NotEmpty(groups = Groups.CreationRestaurant.class)
    @NotBlank(groups = Groups.CreationRestaurant.class)
    private String name;

    @Column(name = "delivery_tax")
    private BigDecimal deliveryTax;

    @Embedded
    @JsonIgnore
    private Address address;
    
    @Valid
    @ManyToOne
    @NotNull(groups = Groups.CreationRestaurant.class)
    private Kitchen kitchen;

    @ManyToMany
    private List<PaymentForm> paymentForms;

    @OneToMany
    private List<Product> products;
    
    @UpdateTimestamp
    @Column(nullable = false, columnDefinition = "timestamp")
    private LocalDateTime updated_at;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "timestamp")
    private LocalDateTime created_at;

    
}
