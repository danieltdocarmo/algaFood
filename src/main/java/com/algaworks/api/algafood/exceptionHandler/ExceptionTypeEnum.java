package com.algaworks.api.algafood.exceptionHandler;

import lombok.Getter;

@Getter
public enum ExceptionTypeEnum {

    ENTITY_CITY_NOT_FOUND_EXCEPTION("CITY NAO ENCONTRADA", 404);

    private final String uri;
    private final int status;

    ExceptionTypeEnum(String uri, int status){
        this.status = status;
        this.uri = uri;
    }
}
