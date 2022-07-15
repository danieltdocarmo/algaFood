package com.algaworks.api.algafood.domain.dtos;

import com.algaworks.api.algafood.domain.model.State;
import lombok.Data;

@Data
public class DTOCity {

    private String name;

    private State state;
}
