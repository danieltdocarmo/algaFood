package com.algaworks.api.algafood.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EntityNotFoundBadRequestException extends RuntimeException{

    public EntityNotFoundBadRequestException(String message){
        super(message);
    }
    
}
