package com.expensetracker.expenseTracker.exceptions.handlers;

import java.util.NoSuchElementException;

import com.expensetracker.expenseTracker.dto.ApiError;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DatabaseExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NoSuchElementException.class)
    public ApiError handleNoSuchElementExceptionExceptions(
            NoSuchElementException ex) {

        String error = ex.getMessage();

        return new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ApiError handleIllegalArgumentExceptionExceptions(
            IllegalArgumentException ex) {

        String error = ex.getMessage();

        return new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
    }

}
