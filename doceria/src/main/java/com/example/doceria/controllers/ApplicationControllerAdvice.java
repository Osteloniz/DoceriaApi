package com.example.doceria.controllers;

import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.doceria.exceptions.ApiErrors;
import com.example.doceria.exceptions.RegraNegocioException;

@RestControllerAdvice
//@ResponseStatus(HttpsStatus.BAD_)
public class ApplicationControllerAdvice {

    @ExceptionHandler(RegraNegocioException.class)
    public ApiErrors handlerRegraNegocioException(RegraNegocioException ex) {
        return new ApiErrors(ex.getMessage());
    }

}
