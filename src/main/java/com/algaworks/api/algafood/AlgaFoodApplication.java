package com.algaworks.api.algafood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.algaworks.api.algafood.repositories.CustomJpaRepositoryImpl;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass= CustomJpaRepositoryImpl.class)
public class AlgaFoodApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlgaFoodApplication.class, args);
    }
}
