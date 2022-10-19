package com.algaworks.api.algafood.domain.interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {FreeTaxWithDescriptionValidator.class})
public @interface FreeTaxWithDescription {
    
  String message() default "Descrição está invalida";

   Class<?>[] groups() default { };

   Class<? extends Payload>[] payload() default { }; 

   String field();

   String fieldDescription();

   String requestDescription();

}
