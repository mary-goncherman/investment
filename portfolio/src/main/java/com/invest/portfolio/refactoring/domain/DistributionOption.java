package com.invest.portfolio.refactoring.domain;

import java.util.List;

public class DistributionOption {
    private String name;
    private String description;
    private List<DistributionCriterion> criteria;

    public DistributionOption(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void addCriterion(DistributionCriterion criterion) {
        this.criteria.add(criterion);
    }

    public String name() {
        return name;
    }

    public List<DistributionCriterion> criteria() {
        return criteria;
    }
}
