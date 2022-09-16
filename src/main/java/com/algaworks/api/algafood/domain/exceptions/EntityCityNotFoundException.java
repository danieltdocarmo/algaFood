package com.algaworks.api.algafood.domain.exceptions;

public class EntityCityNotFoundException extends EntityNotFoundException{

    public EntityCityNotFoundException(String message) {
        super(message);
    }

    public EntityCityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
