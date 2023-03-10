package com.afonsoqueiros.springbootinduction.visacardsapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptions {
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public static class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(){
            super();
            System.out.println("Error 404: Resource not found");
        }
    }

    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    public static class ResourceAlreadyOnDBException extends RuntimeException {
        public ResourceAlreadyOnDBException(){
            super();
            System.out.println("Error 422: Card number already exists on database");
        }
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public static class PayloadInvalidException extends RuntimeException {
        public PayloadInvalidException(){
            super();
            System.out.println("Error 400: Payload Invalid");
        }
    }

}
