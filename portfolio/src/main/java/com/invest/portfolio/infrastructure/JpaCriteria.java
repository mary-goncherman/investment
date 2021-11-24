package com.invest.portfolio.infrastructure;

import com.invest.portfolio.domain.Criteria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "criteria")
public class JpaCriteria {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "distribution")
    private String distribution;

    @Column(name = "main_criteria_id")
    private String mainCriteriaId;

    @Column(name = "priority")
    private int priority;

    public JpaCriteria() {}

    private JpaCriteria(String id, String name, String distribution, String mainCriteriaId, int priority) {
        this.id = id;
        this.name = name;
        this.distribution = distribution;
        this.mainCriteriaId = mainCriteriaId;
        this.priority = priority;
    }

    public static JpaCriteria createFrom(Criteria criteria) {
        return new JpaCriteria(
                criteria.getId(),
                criteria.getName(),
                criteria.getDistributionName(),
                criteria.getMainCriteriaId(),
                criteria.getPriority());
    }
}

