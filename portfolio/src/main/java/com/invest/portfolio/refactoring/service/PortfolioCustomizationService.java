package com.invest.portfolio.refactoring.service;

import com.invest.portfolio.infrastructure.PortfolioRepositoryException;
import com.invest.portfolio.refactoring.domain.*;
import com.invest.portfolio.refactoring.infrastructure.InMemoryInvestmentGoalRepository;
import com.invest.portfolio.refactoring.infrastructure.InMemoryPortfolioRepositoryRefactor;

import java.util.Optional;

public class PortfolioCustomizationService {

    private PortfolioRepositoryRefactor portfolioRepository;
    private InvestmentGoalRepository investmentGoalRepository;

    public PortfolioCustomizationService() {
        this.portfolioRepository = new InMemoryPortfolioRepositoryRefactor();
        this.investmentGoalRepository = new InMemoryInvestmentGoalRepository();
    }

    // создание портфеля
    public String createPortfolio() throws PortfolioCustomizationServiceException {
        try {
            Portfolio portfolio = Portfolio.create();
            portfolioRepository.save(portfolio);

            return portfolio.id();
        } catch (PortfolioRepositoryException e) {
            throw new PortfolioCustomizationServiceException(e);
        }
    }

    public void setPortfolioToInvestmentGoal(String investGoalId, String portfolioId) throws PortfolioCustomizationServiceException {
        try {
            if (investGoalId == null || investGoalId.isEmpty()) {
                throw new PortfolioCustomizationServiceException("Инвестиционная цель для привязки портфеля не задана");
            }
            if (portfolioId == null || portfolioId.isEmpty()) {
                throw new PortfolioCustomizationServiceException("Идентификатор портфеля не задан");
            }
            Optional<InvestmentGoal> investmentGoalOptional = investmentGoalRepository.findBy(investGoalId);
            if (investmentGoalOptional.isPresent()) {
                InvestmentGoal investmentGoal = investmentGoalOptional.get();
                if (investmentGoal.portfolioId() != null && !investmentGoal.portfolioId().isEmpty()) {
                    throw new PortfolioCustomizationServiceException("Инвестиционная цель уже связана с портфелем");
                }
                if (!portfolioRepository.hasPortfolio(portfolioId)) {
                    throw new PortfolioCustomizationServiceException("Портфель с идентификатором " + portfolioId + " не найден");
                }
                investmentGoal.setPortfolioId(portfolioId);
            }
        } catch (PortfolioRepositoryException | InvestmentGoalRepositoryException e) {
            throw new PortfolioCustomizationServiceException(e);
        }
    }


}
