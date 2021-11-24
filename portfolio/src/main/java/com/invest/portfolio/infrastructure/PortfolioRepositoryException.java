package com.invest.portfolio.infrastructure;

public class PortfolioRepositoryException extends Exception {
    public PortfolioRepositoryException(String message) {
        super(message);
    }

    public PortfolioRepositoryException(Throwable cause) {
        super(cause);
    }
}
