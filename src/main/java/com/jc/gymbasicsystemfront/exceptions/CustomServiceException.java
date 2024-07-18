package com.jc.gymbasicsystemfront.exceptions;

public class CustomServiceException extends Exception {
    public CustomServiceException(String message) {
        super(message);
    }

    public CustomServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}