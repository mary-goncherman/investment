package com.invest.portfolio.infrastructure.refactoring;

import com.invest.portfolio.refactoring.domain.DistributionCriterion;
import com.invest.portfolio.domain.DistributionCriterionRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryDistributionCriterionRepository implements DistributionCriterionRepository {

    private Map<String, DistributionCriterion> distributionCriterionMap = new HashMap();

    public InMemoryDistributionCriterionRepository() {

    }

    @Override
    public void save(DistributionCriterion criterion) {
        distributionCriterionMap.put(criterion.name(), criterion);
    }

    @Override
    public Optional<DistributionCriterion> findBy(String id) {
        return Optional.ofNullable(distributionCriterionMap.getOrDefault(id, null));
    }
}
