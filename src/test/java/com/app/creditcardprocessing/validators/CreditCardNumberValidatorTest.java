package com.app.creditcardprocessing.validators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreditCardNumberValidatorTest {

    private CreditCardNumberValidator creditCardNumberValidator;

    public CreditCardNumberValidatorTest() {
        creditCardNumberValidator = new CreditCardNumberValidator();
    }

    @Test
    void test_isValid_falsy_number() {
        String creditCardNumber = "1315464541345431213";
        Boolean isValid = creditCardNumberValidator.isValid(creditCardNumber, null);
        assertEquals(isValid, false);
    }

    @Test
    void test_isValid_correct_number() {
        String creditCardNumber = "79927398713";
        Boolean isValid = creditCardNumberValidator.isValid(creditCardNumber, null);
        assertEquals(isValid, true);
    }
}
