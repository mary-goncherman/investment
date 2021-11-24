package com.invest.operations.service;

public class StockServiceException extends Exception {

    public StockServiceException(String message) {
        super(message);
    }

    public StockServiceException(Throwable cause) {
        super(cause);
    }
}
