package com.invest.analitics.domain;

import java.io.Serializable;

public class AllocationResult implements Serializable {

    private String criteria;
    private float perCent;

    public AllocationResult() {}

    public AllocationResult(String criteria, float perCent) {
        this.criteria = criteria;
        this.perCent = perCent;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public float getPerCent() {
        return perCent;
    }

    public void setPerCent(float perCent) {
        this.perCent = perCent;
    }

    @Override
    public String toString() {
        return "AllocationResult{" +
                "criteria='" + criteria + '\'' +
                ", perCent=" + perCent +
                '}';
    }
}
