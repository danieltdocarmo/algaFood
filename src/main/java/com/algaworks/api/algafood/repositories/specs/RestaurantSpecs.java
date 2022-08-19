package com.algaworks.api.algafood.repositories.specs;

import java.math.BigDecimal;

import org.springframework.data.jpa.domain.Specification;

import com.algaworks.api.algafood.domain.model.Restaurant;

public class RestaurantSpecs {
    
     public static Specification<Restaurant> withFreeTax(){
        return (root, query, criteriaBuilder) -> 
        criteriaBuilder.equal(root.get("deliveryTax"), BigDecimal.ZERO);
    }

     public static Specification<Restaurant> withNameLike(String name){
        return (root, query, criteriaBuilder) -> 
        criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }
}
