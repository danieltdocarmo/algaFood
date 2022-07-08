package com.algaworks.api.algafood.domain.exceptions;

public class AlreadyExistException extends RuntimeException{

    public AlreadyExistException(String message){
        super(message);
    }
}
