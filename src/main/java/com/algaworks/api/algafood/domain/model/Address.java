package com.algaworks.api.algafood.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Embeddable
public class Address {

   private String cep;
   
   private String street;
   
   @Column(name = "street_number")
   private int number;
   
   private String square;
   
   @ManyToOne
   private City city; 

}
