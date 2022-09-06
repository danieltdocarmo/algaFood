package com.algaworks.api.algafood.domain.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Group {
    
    @Id
    @EqualsAndHashCode.Include
    private int id;

    @Column
    private String description;

    @ManyToMany
    private List<Permission> permissions;
}
