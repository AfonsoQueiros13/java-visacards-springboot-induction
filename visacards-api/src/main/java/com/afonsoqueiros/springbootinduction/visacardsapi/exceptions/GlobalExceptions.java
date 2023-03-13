/*
package com.afonsoqueiros.springbootinduction.visacardsapi.exceptions;

import org.springdoc.api.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;


@ControllerAdvice
public class GlobalExceptions {
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public static class ResourceNotFoundException extends RuntimeException  {
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

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ArrayList<String> details = new ArrayList<String>();
        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
        ErrorMessage error = new ErrorMessage(details.toString());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}

*/
