package com.invest.operations.service;

public class OperationServiceException extends Exception {

    public OperationServiceException(String message) {
        super(message);
    }

    public OperationServiceException(Throwable cause) {
        super(cause);
    }
}
