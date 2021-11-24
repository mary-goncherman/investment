package com.invest.portfolio.refactoring.domain;

import java.util.Optional;

public interface InvestmentGoalRepository {
    void save(InvestmentGoal goal) throws InvestmentGoalRepositoryException;
    Optional<InvestmentGoal> findBy(String id) throws InvestmentGoalRepositoryException;
}
