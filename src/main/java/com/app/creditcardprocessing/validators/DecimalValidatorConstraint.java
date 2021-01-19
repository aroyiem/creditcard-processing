package com.app.creditcardprocessing.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


/**
 * Custom bean validator for DOuble field
 * validates for 2 decimal places
 */
@Documented
@Constraint(validatedBy = DecimalValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DecimalValidatorConstraint {
    String message() default "Number can't exceed 2 decimal places";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
