package com.app.creditcardprocessing.exception;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Error implements Serializable {

    private String message;
    private int statusCode;
    private List<CustomFieldError> errors = new ArrayList<>();

    public Error(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public void addAllCustomFieldError(List<CustomFieldError> customFieldErrorList) {
        this.errors = customFieldErrorList;
    }
}
