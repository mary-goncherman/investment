package com.invest.portfolio.infrastructure;

import com.invest.portfolio.domain.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryPortfolioRepository implements PortfolioRepository {

    HashMap<String, Portfolio> portfolioHashMap = new HashMap<>();
    HashMap<String, Criteria> criteriaHashMap = new HashMap<>();
    HashMap<String, PortfolioDistributionResult> distributionResultMap = new HashMap<>();

    public InMemoryPortfolioRepository() {
        // портфели
        portfolioHashMap.put("4a25cde7-d0b4-4d38-b4ef-0cee1049aa8b",
                new Portfolio("4a25cde7-d0b4-4d38-b4ef-0cee1049aa8b", "Основной", 30000000L, LocalDateTime.of(2050, 1, 1, 0, 0), null));
        portfolioHashMap.put("477b159b-c979-47cb-b2ee-04daab7e8586",
                new Portfolio("477b159b-c979-47cb-b2ee-04daab7e8586", "Пенсионный",10000000L, LocalDateTime.of(2045, 1, 1, 0, 0), "4a25cde7-d0b4-4d38-b4ef-0cee1049aa8b"));
        portfolioHashMap.put("c827d996-9019-4315-b616-f71237863ac7",
                new Portfolio("c827d996-9019-4315-b616-f71237863ac7", "Покупка недвижимости",6000000L, LocalDateTime.of(2025, 1, 1, 0, 0), "4a25cde7-d0b4-4d38-b4ef-0cee1049aa8b"));

        // критерии
        // ASSET
        criteriaHashMap.put("4a25cde7-d0b4-4d38-b4ef-0cee1559aa8b", new Criteria("4a25cde7-d0b4-4d38-b4ef-0cee1559aa8b","GOLD", "ASSET",null, 1));
        criteriaHashMap.put("4a25cde7-d0b4-4d38-b4ef-0cee1559aa9b", new Criteria("4a25cde7-d0b4-4d38-b4ef-0cee1559aa9b", "BOND", "ASSET",null, 2));
        criteriaHashMap.put("4a25cdea-d0b4-4d38-b4ef-0cee1559aa0b", new Criteria("4a25cdea-d0b4-4d38-b4ef-0cee1559aa0b", "STOCK", "ASSET",null, 3));

        // STOCK-MARKET
        criteriaHashMap.put("4a25cde7-d0b5-4d38-b4ef-0cee0559aa0b", new Criteria("4a25cde7-d0b5-4d38-b4ef-0cee0559aa0b", "USA_STOCK", "MARKET","4a25cde7-d0b4-4d38-b4ef-0cee1559aa0b", 1));
        criteriaHashMap.put("4a25cde7-d0b6-4d38-b4ef-0cee9559aa0b", new Criteria("4a25cde7-d0b6-4d38-b4ef-0cee9559aa0b", "CHINA_STOCK", "MARKET","4a25cde7-d0b4-4d38-b4ef-0cee1559aa0b", 2));
        criteriaHashMap.put("4a25ade7-d0b7-4d38-b4ef-0cee8559aa0b", new Criteria("4a25ade7-d0b7-4d38-b4ef-0cee8559aa0b", "GERMANY_STOCK", "MARKET","4a25cde7-d0b4-4d38-b4ef-0cee1559aa0b", 3));
        criteriaHashMap.put("4a25cde7-d0b8-4d38-b4ef-0cee7559aa0b", new Criteria("4a25cde7-d0b8-4d38-b4ef-0cee7559aa0b", "RUSSIA_STOCK", "MARKET","4a25cde7-d0b4-4d38-b4ef-0cee1559aa0b", 4));

        // BOND-MARKET
        criteriaHashMap.put("4a25cde7-d0b5-5d38-b4ef-0cee6559aa0b", new Criteria("4a25cde7-d0b5-5d38-b4ef-0cee6559aa0b", "RUSSIA_BOND", "MARKET","4a25cde7-d0b4-4d38-b4ef-0cee1559aa9b", 1));
        criteriaHashMap.put("4a25cae7-d0b6-5d38-b4ef-0cee5559aa0b", new Criteria("4a25cae7-d0b6-5d38-b4ef-0cee5559aa0b", "USA_BOND", "MARKET","4a25cde7-d0b4-4d38-b4ef-0cee1559aa9b", 2));

        // RUSSIA-STOCK-INDUSTRY
        criteriaHashMap.put("7c25cd8a-d2b5-5d38-b44f-3cee225daa0b", new Criteria("7c25cd8a-d2b5-5d38-b44f-3cee225daa0b", "RUSSIA_OIL_GAS_STOCK", "INDUSTRY","4a25cde7-d0b8-4d38-b4ef-0cee7559aa0b", 1));
        criteriaHashMap.put("7c25cd8a-d2b5-5d38-b44f-3cee225daa1b", new Criteria("7c25cd8a-d2b5-5d38-b44f-3cee225daa1b", "RUSSIA_ROW_STOCK", "INDUSTRY","4a25cde7-d0b8-4d38-b4ef-0cee7559aa0b", 2));
        criteriaHashMap.put("7c25cd8a-d2b5-5d38-b44f-3cee225daa2b", new Criteria("7c25cd8a-d2b5-5d38-b44f-3cee225daa2b", "RUSSIA_FOOD_STOCK", "INDUSTRY","4a25cde7-d0b8-4d38-b4ef-0cee7559aa0b", 3));
        criteriaHashMap.put("7c25cd8a-d2b5-5d38-b44f-3cee225daa3b", new Criteria("7c25cd8a-d2b5-5d38-b44f-3cee225daa3b", "RUSSIA_FINANCE_STOCK", "INDUSTRY","4a25cde7-d0b8-4d38-b4ef-0cee7559aa0b", 4));
        criteriaHashMap.put("7c25cd8a-d2b5-5d38-b44f-3cee225daa4b", new Criteria("7c25cd8a-d2b5-5d38-b44f-3cee225daa4b", "RUSSIA_CHEMISTRY_STOCK", "INDUSTRY","4a25cde7-d0b8-4d38-b4ef-0cee7559aa0b", 5));
        criteriaHashMap.put("7c25cd8a-d2b5-5d38-b44f-3cee225daa5b", new Criteria("7c25cd8a-d2b5-5d38-b44f-3cee225daa5b", "RUSSIA_TELECOM_STOCK", "INDUSTRY","4a25cde7-d0b8-4d38-b4ef-0cee7559aa0b", 6));
        criteriaHashMap.put("7c25cd8a-d2b5-5d38-b44f-3cee225daa6b", new Criteria("7c25cd8a-d2b5-5d38-b44f-3cee225daa6b", "RUSSIA_ELECTRICITY_STOCK", "INDUSTRY","4a25cde7-d0b8-4d38-b4ef-0cee7559aa0b", 7));
        criteriaHashMap.put("7c25cd8a-d2b5-5d38-b44f-3cee225daa7b", new Criteria("7c25cd8a-d2b5-5d38-b44f-3cee225daa7b", "RUSSIA_TRANSPORT_STOCK", "INDUSTRY","4a25cde7-d0b8-4d38-b4ef-0cee7559aa0b", 8));

        // портфельное распределение
        distributionResultMap.put("fae85767-5612-46d2-b34b-e2f62110b020",
                new PortfolioDistributionResult("4a25cde7-d0b4-4d38-b4ef-0cee1049aa8b", "4a25cde7-d0b4-4d38-b4ef-0cee1559aa8b", "Основной", "GOLD",1, 10, false));
        distributionResultMap.put("fae85767-5612-46d2-b34b-e2f62110b021",
                new PortfolioDistributionResult("4a25cde7-d0b4-4d38-b4ef-0cee1049aa8b", "4a25cde7-d0b4-4d38-b4ef-0cee1559aa9b","Основной", "BONDS", 2, 20, false));
        distributionResultMap.put("fae85767-5612-46d2-b34b-e2f62110b022",
                new PortfolioDistributionResult("4a25cde7-d0b4-4d38-b4ef-0cee1049aa8b", "4a25cdea-d0b4-4d38-b4ef-0cee1559aa0b", "Основной", "STOCK", 3,  70, false));
        distributionResultMap.put("fae85767-5612-46d2-b34b-e2f62110b023",
                new PortfolioDistributionResult("4a25cde7-d0b4-4d38-b4ef-0cee1049aa8b", "4a25cde7-d0b5-4d38-b4ef-0cee0559aa0b", "Основной", "USA_STOCK", 1,  20, false));
        distributionResultMap.put("fae85767-5612-46d2-b34b-e2f62110b024",
                new PortfolioDistributionResult("4a25cde7-d0b4-4d38-b4ef-0cee1049aa8b", "4a25cde7-d0b6-4d38-b4ef-0cee9559aa0b", "Основной", "CHINA_STOCK",2, 20, false));
        distributionResultMap.put("fae85767-5612-46d2-b34b-e2f62110b025",
                new PortfolioDistributionResult("4a25cde7-d0b4-4d38-b4ef-0cee1049aa8b", "4a25ade7-d0b7-4d38-b4ef-0cee8559aa0b", "Основной", "GERMANY_STOCK", 3, 20, false));
        distributionResultMap.put("fae85767-5612-46d2-b34b-e2f62110b026",
                new PortfolioDistributionResult("4a25cde7-d0b4-4d38-b4ef-0cee1049aa8b", "4a25cde7-d0b8-4d38-b4ef-0cee7559aa0b", "Основной", "RUSSIA_STOCK", 4,  10, false));
        distributionResultMap.put("fae85767-5612-46d2-b34b-e2f62110b027",
                new PortfolioDistributionResult("4a25cde7-d0b4-4d38-b4ef-0cee1049aa8b", "4a25cde7-d0b5-5d38-b4ef-0cee6559aa0b", "Основной", "RUSSIA_BOND", 1,  10, false));
        distributionResultMap.put("fae85767-5612-46d2-b34b-e2f62110b028",
                new PortfolioDistributionResult("4a25cde7-d0b4-4d38-b4ef-0cee1049aa8b", "4a25cae7-d0b6-5d38-b4ef-0cee5559aa0b", "Основной", "USA_BOND", 2,  10, false));
        distributionResultMap.put("fae85767-5612-46d2-b34b-e2f62110b029",
                new PortfolioDistributionResult("4a25cde7-d0b4-4d38-b4ef-0cee1049aa8b", "7c25cd8a-d2b5-5d38-b44f-3cee225daa0b", "Основной", "RUSSIA_OIL_GAS_STOCK", 1, 1.25, false));
        distributionResultMap.put("fae85767-5612-46d2-b34b-e2f62110b030",
                new PortfolioDistributionResult("4a25cde7-d0b4-4d38-b4ef-0cee1049aa8b", "7c25cd8a-d2b5-5d38-b44f-3cee225daa1b", "Основной", "RUSSIA_ROW_STOCK", 2, 1.25, false));
        distributionResultMap.put("fae85767-5612-46d2-b34b-e2f62110b040",
                new PortfolioDistributionResult("4a25cde7-d0b4-4d38-b4ef-0cee1049aa8b", "7c25cd8a-d2b5-5d38-b44f-3cee225daa2b", "Основной", "RUSSIA_FOOD_STOCK", 3, 1.25, false));
        distributionResultMap.put("fae85767-5612-46d2-b34b-e2f62110b050",
                new PortfolioDistributionResult("4a25cde7-d0b4-4d38-b4ef-0cee1049aa8b", "7c25cd8a-d2b5-5d38-b44f-3cee225daa3b", "Основной", "RUSSIA_FINANCE_STOCK", 4, 1.25, false));
        distributionResultMap.put("fae85767-5612-46d2-b34b-e2f62110b060",
                new PortfolioDistributionResult("4a25cde7-d0b4-4d38-b4ef-0cee1049aa8b", "7c25cd8a-d2b5-5d38-b44f-3cee225daa4b", "Основной", "RUSSIA_CHEMISTRY_STOCK", 5, 1.25, false));
        distributionResultMap.put("fae85767-5612-46d2-b34b-e2f62110b070",
                new PortfolioDistributionResult("4a25cde7-d0b4-4d38-b4ef-0cee1049aa8b", "7c25cd8a-d2b5-5d38-b44f-3cee225daa5b", "Основной", "RUSSIA_TELECOM_STOCK", 6, 1.25, false));
        distributionResultMap.put("fae85767-5612-46d2-b34b-e2f62110b080",
                new PortfolioDistributionResult("4a25cde7-d0b4-4d38-b4ef-0cee1049aa8b", "7c25cd8a-d2b5-5d38-b44f-3cee225daa6b", "Основной", "RUSSIA_ELECTRICITY_STOCK", 7, 1.25, false));
        distributionResultMap.put("fae85767-5612-46d2-b34b-e2f62110b090",
                new PortfolioDistributionResult("4a25cde7-d0b4-4d38-b4ef-0cee1049aa8b", "7c25cd8a-d2b5-5d38-b44f-3cee225daa7b", "Основной", "RUSSIA_TRANSPORT_STOCK", 8, 1.25, false));
    }

    @Override
    public void save(Portfolio portfolio) throws PortfolioRepositoryException {
        portfolioHashMap.put(portfolio.id(), portfolio);
    }

    @Override
    public Portfolio findBy(String id) throws PortfolioRepositoryException {
        return portfolioHashMap.getOrDefault(id, null);
    }

    @Override
    public void add(Criteria criteria) throws PortfolioRepositoryException {
        criteriaHashMap.put(criteria.getId(), criteria);
    }

    @Override
    public void apply(PortfolioDistribution portfolioDistribution) throws PortfolioRepositoryException {

        if (!portfolioHashMap.containsKey(portfolioDistribution.getPortfolioId())) {
            throw new PortfolioRepositoryException(new Exception("Портфель не найден"));
        }
        if (!criteriaHashMap.containsKey(portfolioDistribution.getCriteriaId())) {
            throw new PortfolioRepositoryException(new Exception("Критерий не найден"));
        }

        PortfolioDistributionResult result = new PortfolioDistributionResult(
                portfolioDistribution.getPortfolioId(),
                portfolioDistribution.getCriteriaId(),
                portfolioHashMap.get(portfolioDistribution.getPortfolioId()).getName(),
                criteriaHashMap.get(portfolioDistribution.getCriteriaId()).getName(),
                1, // пока заглушка
                portfolioDistribution.getPerCent(),
                portfolioDistribution.isDeleted());
        distributionResultMap.put(portfolioDistribution.getId(), result);
    }

    @Override
    public List<PortfolioDistributionResult> getDistributionForPortfolio(String portfolioId) throws PortfolioRepositoryException {
        return distributionResultMap.values().stream()
                .filter(portfolioDistributionResult -> portfolioDistributionResult.getPortfolioId().equals(portfolioId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Criteria> getCriteriaForDistribution(Distribution distribution) {
        return criteriaHashMap.values().stream()
                .filter(criteria -> criteria.getDistribution().equals(distribution))
                .collect(Collectors.toList());
    }

    @Override
    public List<Criteria> getChildCriteriaForParent(String mainCriterionId) {
        return criteriaHashMap.values().stream()
                .filter(criteria -> criteria.getMainCriteriaId().equals(mainCriterionId))
                .collect(Collectors.toList());
    }

    @Override
    public List<PortfolioDistributionResult> getPortfolioDistributionWithCriteria(String portfolioId, List<Criteria> criteria) throws PortfolioRepositoryException {

        List<String> criteriaIds = criteria.stream().map(Criteria::getId).collect(Collectors.toList());

        return distributionResultMap.values().stream()
                .filter(portfolioDistributionResult -> portfolioDistributionResult.getPortfolioId().equals(portfolioId))
                .filter(portfolioDistributionResult -> criteriaIds.contains(portfolioDistributionResult.getCriteriaId()))
                .collect(Collectors.toList());
    }
}
