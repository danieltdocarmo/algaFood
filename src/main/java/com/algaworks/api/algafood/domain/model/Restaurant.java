package com.algaworks.api.algafood.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.algaworks.api.algafood.domain.interfaces.Groups;
import com.algaworks.api.algafood.domain.interfaces.IsMultiplyFor;
import com.algaworks.api.algafood.domain.interfaces.FreeTaxWithDescription;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Table
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@FreeTaxWithDescription(field = "deliveryTax", 
fieldDescription = "name", 
requestDescription = "Frete Grátis")
public class Restaurant {

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "id")
    private UUID id;

    @Column
    @NotNull
    @NotEmpty
    @NotBlank
    private String name;

    @Column(name = "delivery_tax")
    @IsMultiplyFor(number = 1)
    private BigDecimal deliveryTax;

    @Embedded
    @JsonIgnore
    private Address address;
    
    @Valid
    @ConvertGroup(from = Default.class, to = Groups.CreationRestaurant.class)
    @ManyToOne 
    @NotNull
    @JsonIgnoreProperties(value = "name", allowGetters = true)
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