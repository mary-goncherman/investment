package com.invest.portfolio.refactoring.domain;

public class PortfolioDistribution {
    private String distributionName;
    private DistributionCriterion criterion;
    private int criterionPriority;
    private double criterionPerCent;
    private boolean deleted;

    public PortfolioDistribution(String distributionName, DistributionCriterion criterion, int criterionPriority, double criterionPerCent) {
        this.distributionName = distributionName;
        this.criterion = criterion;
        this.criterionPriority = criterionPriority;
        this.criterionPerCent = criterionPerCent;
        this.deleted = false;
    }
}
