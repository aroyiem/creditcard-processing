package com.app.creditcardprocessing.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Custom validator for credit card number
 * validates credit card number against Luhn 10 algorithm
 */
@Documented
@Constraint(validatedBy = CreditCardNumberValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CreditCardNumberConstraint {
    String message() default "Invalid credit card number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
