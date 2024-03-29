package com.algaworks.api.algafood.exceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(Include.NON_NULL)
public class HandlerException {
    
    private Integer status;
    private String type;
    private String title;
    private String detail;
    private LocalDateTime date;
    private String message;
    private List<Filds> fields;

    @Data
    @Builder
    public static class Filds{
        private String key;
        private String value;
    }
    
}
