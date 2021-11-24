package com.invest.portfolio.refactoring.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class InvestmentGoal {
    private String id;
    private String name;
    private Long targetAmount;
    private LocalDateTime horizon;
    private String portfolioId;

    public InvestmentGoal(String name, Long targetAmount, LocalDateTime horizon) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.targetAmount = targetAmount;
        this.horizon = horizon;
        this.portfolioId = null;
    }

    public String id() {
        return id;
    }

    public String portfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(String portfolioId) {
        this.portfolioId = portfolioId;
    }

    @Override
    public String toString() {
        return "InvestmentGoal{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", targetAmount=" + targetAmount +
                ", horizon=" + horizon +
                ", portfolioId='" + portfolioId + '\'' +
                '}';
    }
}
