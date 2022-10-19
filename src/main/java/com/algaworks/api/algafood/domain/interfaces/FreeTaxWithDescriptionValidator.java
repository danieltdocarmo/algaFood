package com.algaworks.api.algafood.domain.interfaces;

import java.math.BigDecimal;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ValidationException;

import org.springframework.beans.BeanUtils;

public class FreeTaxWithDescriptionValidator implements ConstraintValidator<FreeTaxWithDescription, Object> {
    String field;
    String fieldDescription;
    String requestDescription;

    @Override
    public void initialize(FreeTaxWithDescription freeTaxWithDescription) {
        this.field = freeTaxWithDescription.field();
        this.fieldDescription = freeTaxWithDescription.fieldDescription();
        this.requestDescription = freeTaxWithDescription.requestDescription();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        try {

            var value = (BigDecimal) BeanUtils.getPropertyDescriptor(object.getClass(), field)
                    .getReadMethod().invoke(object);

            var description = (String) BeanUtils.getPropertyDescriptor(object.getClass(), fieldDescription)
                    .getReadMethod().invoke(object);

            if (value != null && BigDecimal.ZERO.compareTo(value) == 0 && description != null) {
                return description.toLowerCase().contains(requestDescription.toLowerCase());
            }

            return false;
        } catch (Exception e) {
            throw new ValidationException(e);
        }

    }

}
