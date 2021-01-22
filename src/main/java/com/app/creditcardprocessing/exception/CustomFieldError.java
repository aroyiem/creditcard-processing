package com.app.creditcardprocessing.exception;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class CustomFieldError implements Serializable {

    private String field;
    private String message;

    public CustomFieldError(String field, String message) {
        this.field = field;
        this.message = message;
    }

    @Override
    public String toString() {
        return "CustomFieldError{" +
                "field='" + field + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
