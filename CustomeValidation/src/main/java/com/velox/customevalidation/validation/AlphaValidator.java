package com.velox.customevalidation.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AlphaValidator implements ConstraintValidator<AlphaOnly, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Value must not be empty").addConstraintViolation();
            return false;
        }

        if (!value.matches("[a-zA-Z]+")) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Only alphabets allowed (A-Z or a-z)").addConstraintViolation();
            return false;
        }

        return true;
    }
}
