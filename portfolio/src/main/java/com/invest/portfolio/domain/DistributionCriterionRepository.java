package com.invest.portfolio.domain;

import com.invest.portfolio.refactoring.domain.DistributionCriterion;

import java.util.Optional;

public interface DistributionCriterionRepository {
    void save(DistributionCriterion criterion);
    Optional<DistributionCriterion> findBy(String id);
}
