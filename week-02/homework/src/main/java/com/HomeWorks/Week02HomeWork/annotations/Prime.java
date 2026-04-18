package com.HomeWorks.Week02HomeWork.annotations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PrimeValidator.class)
public @interface Prime {
    String message() default "Entered Prime should be a prime Number";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
