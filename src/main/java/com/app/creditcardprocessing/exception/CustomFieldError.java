package com.app.creditcardprocessing.exception;

import lombok.Data;

import java.io.Serializable;

@Data
public class CustomFieldError implements Serializable {

    private String field;
    private String message;

    public CustomFieldError(String field, String message) {
        this.field = field;
        this.message = message;
    }
}
