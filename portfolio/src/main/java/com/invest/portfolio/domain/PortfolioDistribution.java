package com.invest.portfolio.domain;

import java.util.UUID;

public class PortfolioDistribution {

    private String id;
    private String portfolioId;
    private String criteriaId;
    private int perCent;
    private boolean deleted;

    public PortfolioDistribution() {}

    private PortfolioDistribution(String id, String portfolioId, String criteriaId, int perCent, boolean deleted) {
        this.id = id;
        this.portfolioId = portfolioId;
        this.criteriaId = criteriaId;
        this.perCent = perCent;
        this.deleted = deleted;
    }

    public static PortfolioDistribution create(String portfolioId, String criteriaId, int perCent) {
        return new PortfolioDistribution(UUID.randomUUID().toString(), portfolioId,criteriaId, perCent, false);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(String portfolioId) {
        this.portfolioId = portfolioId;
    }

    public String getCriteriaId() {
        return criteriaId;
    }

    public void setCriteriaId(String criteriaId) {
        this.criteriaId = criteriaId;
    }

    public int getPerCent() {
        return perCent;
    }

    public void setPerCent(int perCent) {
        this.perCent = perCent;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "PortfolioDistribution : id" + id + " portfolioId " + portfolioId + " criteriaId " + criteriaId + " perCent " + perCent + " deleted " + deleted;
    }
}
