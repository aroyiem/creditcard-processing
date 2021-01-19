package com.app.creditcardprocessing.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CreditCardNumberValidator implements ConstraintValidator<CreditCardNumberConstraint, String> {


    @Override
    public boolean isValid(String creditCardNumber,
                           ConstraintValidatorContext constraintValidatorContext) {
        return validateCreditCardNumber(creditCardNumber);
    }

    // Luhn 10 algorithm
    private boolean validateCreditCardNumber(String cardNumber) {

        int noOfDigits = cardNumber.length();
        int sum=0;
        boolean isSecond = false;

        for(int i = noOfDigits -1; i >= 0; i--) {
            int d = Character.getNumericValue(cardNumber.charAt(i));

            if(isSecond) {
                d = d * 2;
            }
            // take the sum,
            // if it is double digit take the sum of the double digit
            sum += d/10;
            sum += d%10;

            isSecond = !isSecond;
        }
        return (sum % 10 == 0);
    }
}
