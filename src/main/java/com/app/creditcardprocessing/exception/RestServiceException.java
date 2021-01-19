package com.app.creditcardprocessing.exception;

import lombok.Data;

import java.io.Serializable;

@Data
public class RestServiceException extends RuntimeException implements Serializable {

    private String message;

    public RestServiceException(String message) {
        this.message = message;
    }

}
