package com.app.creditcardprocessing.exception;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class RestServiceException extends RuntimeException implements Serializable {

    private String message;

    public RestServiceException(String message) {
        this.message = message;
    }

}
