package com.invest.portfolio.domain;

import javax.persistence.*;

@Entity
@IdClass(ComplexId.class)
@Table(name = "portfolio_distribution_data")
public class PortfolioDistributionResult {

    @Id
    @Column(name = "portfolio_id")
    private String portfolioId;

    @Id
    @Column(name = "criteria_id")
    private String criteriaId;

    @Column(name = "portfolio_name")
    private String portfolioName;

    @Column(name = "criteria_name")
    private String criteriaName;

    @Column(name = "per_cent")
    private double perCent;

    @Column(name = "priority")
    private int criterionPriority;

    @Column(name = "deleted")
    private boolean deleted;

    public PortfolioDistributionResult() {}

    public PortfolioDistributionResult(String portfolioId, String criteriaId, String portfolioName, String criteriaName, int criterionPriority, double perCent, boolean deleted) {
        this.portfolioId = portfolioId;
        this.criteriaId = criteriaId;
        this.portfolioName = portfolioName;
        this.criteriaName = criteriaName;
        this.perCent = perCent;
        this.criterionPriority = criterionPriority;
        this.deleted = deleted;
    }

    public int getCriterionPriority() {
        return criterionPriority;
    }

    public void setCriterionPriority(int criterionPriority) {
        this.criterionPriority = criterionPriority;
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

    public String getPortfolioName() {
        return portfolioName;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    public String getCriteriaName() {
        return criteriaName;
    }

    public void setCriteriaName(String criteriaName) {
        this.criteriaName = criteriaName;
    }

    public double getPerCent() {
        return perCent;
    }

    public void setPerCent(double perCent) {
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
        return "PortfolioDistributionResult{" +
                "portfolioName='" + portfolioName + '\'' +
                ", criteriaName='" + criteriaName + '\'' +
                ", perCent=" + perCent +
                ", criterionPriority=" + criterionPriority +
                ", deleted=" + deleted +
                '}';
    }
}
