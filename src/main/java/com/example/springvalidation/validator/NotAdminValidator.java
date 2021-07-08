package com.example.springvalidation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotAdminValidator implements ConstraintValidator<NotAdmin,String> {
    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        return !name.equalsIgnoreCase("Admin");
    }
}
