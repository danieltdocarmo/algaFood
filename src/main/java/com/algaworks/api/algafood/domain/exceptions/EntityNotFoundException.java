package com.algaworks.api.algafood.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
<<<<<<< HEAD
public class EntityNotFoundException extends RuntimeException{
    
=======
public abstract class EntityNotFoundException extends RuntimeException{

>>>>>>> 881f8f5a9d51cb485e9fbf63f1b85edfa29c32e0
    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause) {super(message, cause);}
}
