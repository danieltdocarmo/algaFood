package com.algaworks.api.algafood.exceptionHandler;

import java.util.Objects;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.algaworks.api.algafood.domain.exceptions.EntityCityNotFoundException;
import com.algaworks.api.algafood.domain.exceptions.EntityStateNotFoundException;

@ControllerAdvice
public class ApiHandlerException extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, 
    HttpHeaders headers, HttpStatus status, WebRequest request) {

        body = HandlerException.builder()
        .title(Objects.isNull(body) ? status.getReasonPhrase() : (String) body)
        .status(status.value())
        .build();

        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    @ExceptionHandler(EntityCityNotFoundException.class)
    public ResponseEntity<?> exceptionHandlerCityController(EntityCityNotFoundException ex) {
       
        this.handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), ex., request)

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(EntityStateNotFoundException.class)
    public ResponseEntity<?> exceptionHandlerCityController(EntityStateNotFoundException e) {
      
      
      
        return ResponseEntity.badRequest().body(e.getMessage());
    }
  
}
