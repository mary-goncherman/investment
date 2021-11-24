package com.invest.portfolio.domain;

import java.util.UUID;

public class Criteria {

    private String id;
    private String name;
    private Distribution distribution;
    private String mainCriteriaId;
    private int priority;

    public Criteria() {}

    private Criteria(String id, String name, Distribution distribution, String mainCriteriaId, int priority) {
        this.id = id;
        this.name = name;
        this.distribution = distribution;
        this.mainCriteriaId = mainCriteriaId;
        this.priority = priority;
    }

    public Criteria(String id, String name, String distribution, String mainCriteriaId, int priority) {
        this.id = id;
        this.name = name;
        this.distribution = Distribution.getByName(distribution);
        this.mainCriteriaId = mainCriteriaId;
        this.priority = priority;
    }

    public static Criteria create(String name, String distribution, String mainCriteriaId, int priority) {
        return new Criteria(UUID.randomUUID().toString(), name, Distribution.getByName(distribution), mainCriteriaId, priority);
    }

    public String getDistributionName() {
        return distribution.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Distribution getDistribution() {
        return distribution;
    }

    public void setDistribution(Distribution distribution) {
        this.distribution = distribution;
    }

    public String getMainCriteriaId() {
        return mainCriteriaId;
    }

    public void setMainCriteriaId(String mainCriteriaId) {
        this.mainCriteriaId = mainCriteriaId;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
