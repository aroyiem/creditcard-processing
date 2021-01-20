package com.app.creditcardprocessing.validators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DecimalValidatorTest {

    private DecimalValidator decimalValidator;

    public DecimalValidatorTest() {
        decimalValidator = new DecimalValidator();
    }

    @Test
    void test_isValid_wrong() {
        Double value = 10.0234d;
        Boolean isValid = decimalValidator.isValid(value, null);
        assertEquals(isValid, false);
    }

    @Test
    void test_isValid_right() {
        Double value = 10.02d;
        Boolean isValid = decimalValidator.isValid(value, null);
        assertEquals(isValid, true);
    }
}
