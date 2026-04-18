package com.HomeWorks.Week02HomeWork.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PrimeValidator implements ConstraintValidator<Prime,Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context){
        if(value<=1) return false;
        for(int i=2;i*i<=value;i++){
            if(value%i==0) return false;
        }
        return true;
    }
}
