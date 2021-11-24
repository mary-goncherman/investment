package com.invest.portfolio.refactoring.infrastructure;

import com.invest.portfolio.infrastructure.PortfolioRepositoryException;
import com.invest.portfolio.refactoring.domain.Portfolio;
import com.invest.portfolio.refactoring.domain.PortfolioRepositoryRefactor;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryPortfolioRepositoryRefactor implements PortfolioRepositoryRefactor {

    private Map<String, Portfolio> portfolioMap = new HashMap();

    public InMemoryPortfolioRepositoryRefactor() {

        // для упрощение рассмотрим случай с одним портфелем
        Portfolio mainPortfolio = Portfolio.create();
        mainPortfolio
                .addDistributionLevel(1, "ASSET")
                .addDistributionLevel(2, "MARKET")
                .addDistributionLevel(3, "INDUSTRY")
                .addCriterion("ASSET", "GOLD", 1, 10)
                .addCriterion("ASSET", "BONDS", 2, 20)
                .addCriterion("ASSET", "STOCK", 3, 70)
                .addDependentCriterion("MARKET", "STOCK", "USA_STOCK", 1, 20)
                .addDependentCriterion("MARKET","STOCK", "CHINA_STOCK", 2, 20)
                .addDependentCriterion("MARKET","STOCK", "GERMANY_STOCK", 3, 20)
                .addDependentCriterion("MARKET", "STOCK","RUSSIA_STOCK", 4, 10)
                .addDependentCriterion("MARKET", "BONDS", "RUSSIA_BOND", 1, 10)
                .addDependentCriterion("MARKET", "BONDS", "USA_BOND", 2,  10)
                .addDependentCriterion("INDUSTRY", "RUSSIA_STOCK","RUSSIA_OIL_GAS_STOCK", 1, 1.25)
                .addDependentCriterion("INDUSTRY", "RUSSIA_STOCK","RUSSIA_ROW_STOCK", 2, 1.25)
                .addDependentCriterion("INDUSTRY", "RUSSIA_STOCK","RUSSIA_FOOD_STOCK", 3, 1.25)
                .addDependentCriterion("INDUSTRY", "RUSSIA_STOCK","RUSSIA_FINANCE_STOCK", 4, 1.25)
                .addDependentCriterion("INDUSTRY", "RUSSIA_STOCK","RUSSIA_CHEMISTRY_STOCK", 5, 1.25)
                .addDependentCriterion("INDUSTRY", "RUSSIA_STOCK","RUSSIA_TELECOM_STOCK", 6, 1.25)
                .addDependentCriterion("INDUSTRY", "RUSSIA_STOCK","RUSSIA_ELECTRICITY_STOCK", 7, 1.25)
                .addDependentCriterion("INDUSTRY", "RUSSIA_STOCK","RUSSIA_TRANSPORT_STOCK", 8, 1.25);


        portfolioMap.put(mainPortfolio.id(), mainPortfolio);



    }

//        portfolioMap.put("477b159b-c979-47cb-b2ee-04daab7e8586",
//                new Portfolio("477b159b-c979-47cb-b2ee-04daab7e8586", "Пенсионный",10000000L, LocalDateTime.of(2045, 1, 1, 0, 0), "4a25cde7-d0b4-4d38-b4ef-0cee1049aa8b"));
//        portfolioMap.put("c827d996-9019-4315-b616-f71237863ac7",
//                new Portfolio("c827d996-9019-4315-b616-f71237863ac7", "Покупка недвижимости",6000000L, LocalDateTime.of(2025, 1, 1, 0, 0), "4a25cde7-d0b4-4d38-b4ef-0cee1049aa8b"));
//


    @Override
    public void save(Portfolio portfolio) throws PortfolioRepositoryException {
        portfolioMap.put(portfolio.id(), portfolio);
    }

    @Override
    public Optional<Portfolio> findBy(String id) throws PortfolioRepositoryException {
        return Optional.ofNullable(portfolioMap.getOrDefault(id, null));
    }

    @Override
    public boolean hasPortfolio(String id) throws PortfolioRepositoryException {
        return portfolioMap.containsKey(id);
    }


}
