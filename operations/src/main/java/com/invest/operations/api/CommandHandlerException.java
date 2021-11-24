package com.invest.operations.api;

public class CommandHandlerException extends Exception {
    public CommandHandlerException(String message) {
        super(message);
    }

    public CommandHandlerException(Throwable cause) {
        super(cause);
    }
}
