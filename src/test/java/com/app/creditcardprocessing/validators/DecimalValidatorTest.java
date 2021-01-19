package com.app.creditcardprocessing.validators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class DecimalValidatorTest {

    private DecimalValidator decimalValidator;

    @BeforeEach
    public void setUp() {
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
