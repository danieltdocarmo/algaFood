package com.algaworks.api.algafood.domain.interfaces;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsMultiplyForValidator implements ConstraintValidator<IsMultiplyFor, Number>{

    private int number;

    @Override
    public void initialize(IsMultiplyFor constraintAnnotation) {
        this.number = constraintAnnotation.number();
    }
   
    @Override
    public boolean isValid(Number value, ConstraintValidatorContext context) {
        if(value != null && value.doubleValue() % number == 0){
            return true;
        } else {
            return false;
        }
    }

}