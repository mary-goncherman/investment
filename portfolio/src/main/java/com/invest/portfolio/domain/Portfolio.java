package com.invest.portfolio.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class Portfolio {

    private String id;
    private String name;
    private Long targetAmount;
    private LocalDateTime horizon;
    private String mainPortfolioId;

    public Portfolio() {}

    public Portfolio(String id, String name, Long targetAmount, LocalDateTime horizon, String mainPortfolioId) {
        this.id = id;
        this.name = name;
        this.targetAmount = targetAmount;
        this.horizon = horizon;
        this.mainPortfolioId = mainPortfolioId;
    }

    public static Portfolio create(String name, Long targetAmount, LocalDateTime horizon, String mainPortfolioId) {
        return new Portfolio(UUID.randomUUID().toString(), name, targetAmount, horizon, mainPortfolioId);
    }

    public static Portfolio build(String uuid, String name, Long targetAmount, LocalDateTime horizon, String mainPortfolioId) {
        return new Portfolio(uuid, name, targetAmount, horizon, mainPortfolioId);
    }

    public String id() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(Long targetAmount) {
        this.targetAmount = targetAmount;
    }

    public LocalDateTime getHorizon() {
        return horizon;
    }

    public void setHorizon(LocalDateTime horizon) {
        this.horizon = horizon;
    }

    public String getMainPortfolioId() {
        return mainPortfolioId;
    }

    public void setMainPortfolioId(String mainPortfolioId) {
        this.mainPortfolioId = mainPortfolioId;
    }

    @Override
    public String toString() {
        return "Portfolio: " + id + " " + name + " " + targetAmount + " " + horizon  + " " + mainPortfolioId;
    }
}
