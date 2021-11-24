package com.invest.portfolio.domain;

import com.invest.portfolio.infrastructure.PortfolioRepositoryException;

import java.util.List;

public interface PortfolioRepository {

    void save(Portfolio portfolio) throws PortfolioRepositoryException;
    Portfolio findBy(String id) throws PortfolioRepositoryException;
    void add(Criteria criteria) throws PortfolioRepositoryException;
    void apply(PortfolioDistribution portfolioDistribution) throws PortfolioRepositoryException;
    List<PortfolioDistributionResult> getDistributionForPortfolio(String portfolioId) throws PortfolioRepositoryException;

    List<Criteria> getCriteriaForDistribution(Distribution distribution) throws PortfolioRepositoryException;
    List<Criteria> getChildCriteriaForParent(String mainCriterionId) throws PortfolioRepositoryException;

    List<PortfolioDistributionResult> getPortfolioDistributionWithCriteria(String portfolioId, List<Criteria> criteria) throws PortfolioRepositoryException;
}
