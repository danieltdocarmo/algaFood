package com.algaworks.api.algafood.domain.exceptions;

public class EntityStateNotFoundException extends EntityNotFoundException{

    public EntityStateNotFoundException(String message) {
        super(message);
    }

    public EntityStateNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
