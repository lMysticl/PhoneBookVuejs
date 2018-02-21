package com.mystic.validation;

/**
 * @author Pavel Putrenkov
 * @version 1.0
 * @since
 */

import com.mystic.model.entity.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsCorrectUserValidator implements ConstraintValidator<IsCorrectUser, User> {
    @Override
    public void initialize(IsCorrectUser constraintAnnotation) {

    }

    @Override
    public boolean isValid(User value, ConstraintValidatorContext context) {
        if (value == null) return true;

        if (value.getUsername() == null || value.getPassword().isEmpty()||value.getUsername().isEmpty()|| value.getPassword()==null) {

            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Name or password is required")
                    .addPropertyNode("name").addConstraintViolation();
            return false;
        }

        return true;

    }

}