package com.Week02Codes.SpringBootWebApplication.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PrimeNumberValidator implements ConstraintValidator<PrimeNumberValidation, Integer> {
    @Override
    public boolean isValid(Integer inputNumber, ConstraintValidatorContext constraintValidatorContext) {
        boolean isPrime = true;
        for(int i=2; i<inputNumber; i++) {
            if(inputNumber % i == 0) {
                isPrime = false;
            }
        }
        return isPrime;
    }
}
