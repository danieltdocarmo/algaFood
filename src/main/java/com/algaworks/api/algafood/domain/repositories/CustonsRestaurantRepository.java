package com.algaworks.api.algafood.domain.repositories;

import com.algaworks.api.algafood.domain.model.Restaurant;

import java.util.List;

public interface CustonsRestaurantRepository {

     List<Restaurant> findByNameAndTaxs(String name, Double initialTax, Double FinalTax);

     List<Restaurant> findWithNameAndFreeTax(String name);
}

