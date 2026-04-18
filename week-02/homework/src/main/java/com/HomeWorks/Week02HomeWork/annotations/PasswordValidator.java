package com.HomeWorks.Week02HomeWork.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context){
        if(value==null) return true;
        boolean hasUpper=false;
        boolean hasLower=false;
        boolean hasSpecial= false;
        for(char c : value.toCharArray()){
            if(Character.isUpperCase(c)) hasUpper=true;
            else if(Character.isLowerCase(c)) hasLower=true;
            else if(!Character.isLetterOrDigit(c)) hasSpecial=true;
        }
        return value.length() >=10 && hasUpper && hasLower && hasSpecial;
    }
}
