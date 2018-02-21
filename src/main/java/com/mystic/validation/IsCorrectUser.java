package com.mystic.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Pavel Putrenkov
 * @version 1.0
 * @since
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { IsCorrectUserValidator.class })
public @interface IsCorrectUser {

    String message() default "User is incorrect";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
