package com.expensetracker.expenseTracker.exceptions.handlers;

import com.expensetracker.expenseTracker.dto.ApiError;
import com.expensetracker.expenseTracker.exceptions.InvalidAlgorithmException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class InvalidAlgorithmExceptionHandler {
    
    @ExceptionHandler({ InvalidAlgorithmException.class })
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(
        InvalidAlgorithmException ex, WebRequest request) {

        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), ex.getMessage());
        return new ResponseEntity<Object>(
                apiError, new HttpHeaders(), apiError.getStatus());
    }

}
