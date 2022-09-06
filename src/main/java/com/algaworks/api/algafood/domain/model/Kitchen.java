package com.algaworks.api.algafood.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Kitchen {
   
    @EqualsAndHashCode.Include
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "kitchen")
    private List<Restaurant> restaurants;

    @UpdateTimestamp
    @Column(nullable = false, columnDefinition = "timestamp")
    private LocalDateTime updated_at;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "timestamp")
    private LocalDateTime created_at;

    public Kitchen(){
        if(this.id == null){
            this.id = UUID.randomUUID();
        }
    }

    public Kitchen(String name){
        this.name = name;
    }
}
