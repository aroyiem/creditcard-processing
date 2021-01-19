package com.app.creditcardprocessing.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public final Error handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex) {
        final List<FieldError> errors = ex.getBindingResult().getFieldErrors();
        final List<CustomFieldError> customFieldErrors = new ArrayList<>();

        errors.forEach(error->
            customFieldErrors.add(new CustomFieldError(error.getField(), error.getDefaultMessage()))
        );

        Error error = new Error("Invalid Request", HttpStatus.BAD_REQUEST.value());
        error.addAllCustomFieldError(customFieldErrors);
        return error;
    }

    @ExceptionHandler({RestServiceException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public final Error getErrorForRestService(final RestServiceException restServiceException) {
        return new Error(restServiceException.getMessage(), HttpStatus.BAD_REQUEST.value());
    }
}
