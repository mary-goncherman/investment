package com.invest.portfolio.domain;

import java.io.Serializable;

public class ComplexId implements Serializable {

    private String portfolioId;
    private String criteriaId;
    private int perCent;
    private boolean deleted;

    public ComplexId() {}

    public ComplexId(String portfolioId, String criteriaId, int perCent, boolean deleted) {
        this.portfolioId = portfolioId;
        this.criteriaId = criteriaId;
        this.perCent = perCent;
        this.deleted = deleted;
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
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ComplexId))
            return false;
        ComplexId other = (ComplexId)o;
        boolean portfolioIdEquals = ((this.portfolioId == null) && (other.portfolioId == null)) || (this.portfolioId.equals(other.portfolioId));
        boolean criteriaIdEquals = ((this.criteriaId == null) && (other.criteriaId == null)) || (this.criteriaId.equals(other.criteriaId));
        return portfolioIdEquals && criteriaIdEquals && other.perCent == this.perCent && other.deleted == this.deleted;
    }

    @Override
    public int hashCode() {
        int result = perCent;
        if (portfolioId != null) {
            result = 28 * result + portfolioId.hashCode();
        }
        if (criteriaId != null) {
            result = 28 * result + criteriaId.hashCode();
        }
        return result;
    }
}
