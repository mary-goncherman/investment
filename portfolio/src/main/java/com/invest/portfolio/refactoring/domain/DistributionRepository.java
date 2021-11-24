package com.invest.portfolio.refactoring.domain;

import java.util.List;

public interface DistributionRepository {

    void save(DistributionOption distribution);
    List<DistributionOption> allDistributionOptions();
    List<DistributionCriterion> distributionOptionCriteria(String distributionName);
}
