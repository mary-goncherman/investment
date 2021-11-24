package com.invest.portfolio.refactoring.domain;

public class DistributionCriterion {

    private String name;
    private String parentCriterionName;
    private boolean deleted;

    public DistributionCriterion(String name, String parentCriterionName, boolean deleted) {
        this.name = name;
        this.parentCriterionName = parentCriterionName;
        this.deleted = deleted;
    }

    public static DistributionCriterion create(String name, String parentCriterionId) {
        return new DistributionCriterion(name, parentCriterionId, false);
    }

    public void delete() {
        this.deleted = true;
    }

    public String name() {
        return name;
    }

    public String parentCriterionName() {
        return parentCriterionName;
    }

    public boolean isDeleted() {
        return deleted;
    }
}
