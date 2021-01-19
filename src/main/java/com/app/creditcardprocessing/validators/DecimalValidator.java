package com.app.creditcardprocessing.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DecimalValidator implements ConstraintValidator<DecimalValidatorConstraint, Double> {

    @Override
    public boolean isValid(Double value,
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
