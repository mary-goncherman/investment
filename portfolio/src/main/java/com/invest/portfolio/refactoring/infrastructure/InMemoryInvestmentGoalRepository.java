package com.invest.portfolio.refactoring.infrastructure;

import com.invest.portfolio.refactoring.domain.InvestmentGoal;
import com.invest.portfolio.refactoring.domain.InvestmentGoalRepository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryInvestmentGoalRepository implements InvestmentGoalRepository {

    Map<String, InvestmentGoal> investmentGoalMap = new HashMap<>();

    public InMemoryInvestmentGoalRepository() {
        InvestmentGoal investmentGoal = new InvestmentGoal("Пенсионный",10000000L, LocalDateTime.of(2045, 1, 1, 0, 0));
        investmentGoalMap.put(investmentGoal.id(), investmentGoal);
    }

    @Override
    public void save(InvestmentGoal goal) {
        investmentGoalMap.put(goal.id(), goal);
    }

    @Override
    public Optional<InvestmentGoal> findBy(String id) {
        return Optional.ofNullable(investmentGoalMap.getOrDefault(id, null));
    }
}
