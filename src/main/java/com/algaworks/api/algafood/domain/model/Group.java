package com.algaworks.api.algafood.domain.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Group {
    
    
    @Id
    private UUID id;

    @Column
    private String description;

    @ManyToMany
    private List<Permission> permissions;
}
