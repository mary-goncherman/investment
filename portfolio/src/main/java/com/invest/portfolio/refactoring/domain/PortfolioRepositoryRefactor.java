package com.invest.portfolio.refactoring.domain;


import com.invest.portfolio.infrastructure.PortfolioRepositoryException;

import java.util.Optional;

public interface PortfolioRepositoryRefactor {
    void save(Portfolio portfolio) throws PortfolioRepositoryException;
    Optional<Portfolio> findBy(String id) throws PortfolioRepositoryException;
    boolean hasPortfolio(String id) throws PortfolioRepositoryException;
}
