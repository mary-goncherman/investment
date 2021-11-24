package com.invest.portfolio.refactoring.service;

public class PortfolioCustomizationServiceException extends Exception {
    public PortfolioCustomizationServiceException(String message) {
        super(message);
    }

    public PortfolioCustomizationServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public PortfolioCustomizationServiceException(Throwable cause) {
        super(cause);
    }
}
