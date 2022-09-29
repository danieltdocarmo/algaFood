package com.algaworks.api.algafood.exceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.algaworks.api.algafood.domain.exceptions.EntityCityNotFoundException;
import com.algaworks.api.algafood.domain.exceptions.EntityStateNotFoundException;
import com.algaworks.api.algafood.exceptionHandler.HandlerException.Filds;

@ControllerAdvice
public class ApiHandlerException extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body,
    HttpHeaders headers, HttpStatus status, WebRequest request) {

        final var problem = HandlerException.builder()
                .title(ex.getClass().getSimpleName().toString())
                .date(LocalDateTime.now())
                .message(ex.getMessage())
                .build();

        return super.handleExceptionInternal(ex, problem, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
        
        List<Filds> filds = ex.getBindingResult().getFieldErrors().stream().map(fieldError -> {
            return Filds.builder()
            .key(fieldError.getField())
            .value(fieldError.getDefaultMessage())
            .build();
        }).collect(Collectors.toList());
        
        HandlerException problem = 
        HandlerException.builder()
        .date(LocalDateTime.now())
        .title(ex.getClass().getSimpleName())
        .message(ex.getMessage())
        .fields(filds)
        .build();

        return super.handleExceptionInternal(ex, problem, headers, status, request);
    }

    @ExceptionHandler(EntityCityNotFoundException.class)
    public ResponseEntity<?> exceptionHandlerCityController(EntityCityNotFoundException ex, WebRequest request) {
        return this.handleExceptionInternal(ex, ExceptionTypeEnum.ENTITY_CITY_NOT_FOUND_EXCEPTION, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(EntityStateNotFoundException.class)
    public ResponseEntity<?> exceptionHandlerStateController(EntityStateNotFoundException ex, WebRequest request) {
        return this.handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }



    
  
  
}
