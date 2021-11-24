package com.invest.portfolio.refactoring.domain;

public class DistributionLevel {
    private String distributionName;
    private int level;

    public DistributionLevel(String distribution, int level) {
        this.distributionName = distribution;
        this.level = level;
    }
}
