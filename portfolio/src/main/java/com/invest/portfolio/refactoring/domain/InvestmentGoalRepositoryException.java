package com.invest.portfolio.refactoring.domain;

public class InvestmentGoalRepositoryException extends Exception{
    public InvestmentGoalRepositoryException(String message) {
        super(message);
    }

    public InvestmentGoalRepositoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvestmentGoalRepositoryException(Throwable cause) {
        super(cause);
    }
}
