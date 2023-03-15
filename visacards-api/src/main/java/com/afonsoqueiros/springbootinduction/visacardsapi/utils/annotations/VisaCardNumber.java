package com.afonsoqueiros.springbootinduction.visacardsapi.utils.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = VisaCardNumberImpl.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface VisaCardNumber {
    String message() default "Invalid VISA number";

    boolean isValid() default false;;
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String value() default "";

}
