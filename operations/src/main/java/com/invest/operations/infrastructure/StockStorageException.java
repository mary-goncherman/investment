package com.invest.operations.infrastructure;

public class StockStorageException extends Exception {

    public StockStorageException(String message) {
        super(message);
    }

    public StockStorageException(Throwable cause) {
        super(cause);
    }
}
