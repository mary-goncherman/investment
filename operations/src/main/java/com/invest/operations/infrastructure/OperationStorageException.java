package com.invest.operations.infrastructure;

public class OperationStorageException extends Exception {

    public OperationStorageException(String message) {
        super(message);
    }

    public OperationStorageException(Throwable cause) {
        super(cause);
    }
}
