package com.invest.analitics.service;

public class AnaliticServiceException extends Exception {
    public AnaliticServiceException(String message) {
        super(message);
    }

    public AnaliticServiceException(Throwable cause) {
        super(cause);
    }
}
