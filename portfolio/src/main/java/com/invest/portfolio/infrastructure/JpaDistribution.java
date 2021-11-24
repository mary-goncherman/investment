package com.invest.portfolio.infrastructure;

import com.invest.portfolio.domain.PortfolioDistribution;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "portfolio_distribution")
public class JpaDistribution {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "portfolio_id")
    private String portfolioId;

    @Column(name = "criteria_id")
    private String criteriaId;

    @Column(name = "per_cent")
    private int perCent;

    @Column(name = "deleted")
    private boolean deleted;

    public JpaDistribution() {}

    private JpaDistribution(String id, String portfolioId, String criteriaId, int perCent, boolean deleted) {
        this.id = id;
        this.portfolioId = portfolioId;
        this.criteriaId = criteriaId;
        this.perCent = perCent;
        this.deleted = deleted;
    }

    public static JpaDistribution createFrom(PortfolioDistribution distribution) {
        return new JpaDistribution(distribution.getId(),
                distribution.getPortfolioId(),
                distribution.getCriteriaId(),
                distribution.getPerCent(),
                distribution.isDeleted());
    }

    @Override
    public String toString() {
        return "JpaDistribution : id" + id + " portfolioId " + portfolioId + " criteriaId " + criteriaId + " perCent " + perCent + " deleted " + deleted;
    }
}
