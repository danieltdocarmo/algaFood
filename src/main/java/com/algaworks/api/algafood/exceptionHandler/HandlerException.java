package com.algaworks.api.algafood.exceptionHandler;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class HandlerException {

    private LocalDateTime date;
    private String message;

}
