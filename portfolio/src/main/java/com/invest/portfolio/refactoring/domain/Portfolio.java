package com.invest.portfolio.refactoring.domain;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Portfolio {

    private String id;
    private Map<Integer, String> distributionLevels;
    private List<PortfolioDistribution> distributions;

    private Portfolio(String id) {
        this.id = id;
    }

    public static Portfolio create() {
        return new Portfolio(UUID.randomUUID().toString());
    }

    public Portfolio withDistributionLevels(Map<Integer, String> distributionLevels) {
        this.distributionLevels = distributionLevels;
        return this;
    }

    public Portfolio addDistributionLevel(int level, String distributionName) {
        this.distributionLevels.put(level, distributionName.toUpperCase());
        return this;
    }

    public Portfolio addCriterion(String distribution, String criterionName, int priority, double perCent) {
        DistributionCriterion criterion = DistributionCriterion.create(criterionName, null);
        PortfolioDistribution distributionCriteria = new PortfolioDistribution(distribution, criterion, priority, perCent);
        this.distributions.add(distributionCriteria);
        return this;
    }

    public Portfolio addDependentCriterion(String distribution, String parentCriterionName, String criterionName, int priority, double perCent) {
        DistributionCriterion criterion = DistributionCriterion.create(criterionName, parentCriterionName);
        PortfolioDistribution distributionCriteria = new PortfolioDistribution(distribution, criterion, priority, perCent);
        this.distributions.add(distributionCriteria);
        return this;
    }

    public String id() {
        return id;
    }


}
