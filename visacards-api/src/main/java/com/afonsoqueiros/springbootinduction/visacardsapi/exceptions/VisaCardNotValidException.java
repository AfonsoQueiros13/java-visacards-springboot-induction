package com.afonsoqueiros.springbootinduction.visacardsapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class VisaCardNotValidException extends Exception{

    private static final long serialVersionUID = 1L;

    public VisaCardNotValidException(String message){
        super(message);
    }
}