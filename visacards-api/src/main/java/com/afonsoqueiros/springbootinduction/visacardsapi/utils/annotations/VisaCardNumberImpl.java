package com.afonsoqueiros.springbootinduction.visacardsapi.utils.annotations;

import com.afonsoqueiros.springbootinduction.visacardsapi.exceptions.VisaCardNotValidException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;

public class VisaCardNumberImpl implements ConstraintValidator<VisaCardNumber,String>{
    public boolean isValid(String visaNumber, ConstraintValidatorContext constraintValidatorContext) {
        int sum = 0;
        boolean alternate = false;
        for (int i = visaNumber.length() - 1; i >= 0; i--)
        {
            int n = Integer.parseInt(visaNumber.substring(i, i + 1));
            if (alternate)
            {
                n *= 2;
                if (n > 9)
                {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        if(sum % 10 == 0){
            return true;
        }
        else{
            try {
                throw new VisaCardNotValidException("This VISA Card does not obey to the rules in:  https://www.freeformatter.com/credit-card-number-generator-validator.html");
            } catch (VisaCardNotValidException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
