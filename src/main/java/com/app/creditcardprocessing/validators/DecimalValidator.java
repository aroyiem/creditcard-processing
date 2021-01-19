package com.app.creditcardprocessing.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

public class DecimalValidator implements ConstraintValidator<DecimalValidatorConstraint, BigDecimal> {

    @Override
    public boolean isValid(BigDecimal value,
                           ConstraintValidatorContext constraintValidatorContext) {
        // field can have null value
        if(null == value) {
            return true;
        }
        String[] splitter = value.toString().split("\\.");

        // check if decimal is present or not
        if(splitter.length <= 1) {
            return true;
        }
        int decimalLength = splitter[1].length();
        return (decimalLength <= 2);
    }
}
