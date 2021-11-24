package com.invest.portfolio.refactoring.infrastructure;

import com.invest.portfolio.refactoring.domain.DistributionCriterion;
import com.invest.portfolio.refactoring.domain.DistributionOption;
import com.invest.portfolio.refactoring.domain.DistributionRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryDistributionRepository implements DistributionRepository {

    private Map<String, DistributionOption> distributionMap = new HashMap<>();

    public InMemoryDistributionRepository() {
        DistributionOption assetAllocation = new DistributionOption("ASSET", "Распределение по видам активов");
        assetAllocation.addCriterion(new DistributionCriterion("GOLD", null, false));
        assetAllocation.addCriterion(new DistributionCriterion("BOND", null, false));
        assetAllocation.addCriterion(new DistributionCriterion("STOCK", null, false));

        distributionMap.put(assetAllocation.name(), assetAllocation);

        DistributionOption marketAllocation = new DistributionOption("MARKET", "Страновое распределение");
        marketAllocation.addCriterion(new DistributionCriterion( "USA_STOCK", "STOCK", false));
        marketAllocation.addCriterion(new DistributionCriterion("CHINA_STOCK", "STOCK", false));
        marketAllocation.addCriterion(new DistributionCriterion("GERMANY_STOCK", "STOCK", false));
        marketAllocation.addCriterion(new DistributionCriterion("RUSSIA_STOCK","STOCK", false));

        marketAllocation.addCriterion(new DistributionCriterion("RUSSIA_BOND", "BOND", false));
        marketAllocation.addCriterion(new DistributionCriterion("USA_BOND", "BOND", false));

        distributionMap.put(marketAllocation.name(), marketAllocation);

        DistributionOption industryAllocation = new DistributionOption("INDUSTRY",  "Распределение по отраслям");

        industryAllocation.addCriterion(new DistributionCriterion("RUSSIA_OIL_GAS_STOCK", "RUSSIA_STOCK", false));
        industryAllocation.addCriterion(new DistributionCriterion("RUSSIA_ROW_STOCK", "RUSSIA_STOCK", false));
        industryAllocation.addCriterion(new DistributionCriterion("RUSSIA_FOOD_STOCK", "RUSSIA_STOCK", false));
        industryAllocation.addCriterion(new DistributionCriterion("RUSSIA_FINANCE_STOCK", "RUSSIA_STOCK", false));
        industryAllocation.addCriterion(new DistributionCriterion("RUSSIA_CHEMISTRY_STOCK", "RUSSIA_STOCK", false));
        industryAllocation.addCriterion(new DistributionCriterion("RUSSIA_TELECOM_STOCK", "RUSSIA_STOCK", false));
        industryAllocation.addCriterion(new DistributionCriterion("RUSSIA_ELECTRICITY_STOCK", "RUSSIA_STOCK", false));
        industryAllocation.addCriterion(new DistributionCriterion("RUSSIA_TRANSPORT_STOCK", "RUSSIA_STOCK", false));

        distributionMap.put(industryAllocation.name(), industryAllocation);
    }

    @Override
    public void save(DistributionOption distribution) {
        distributionMap.put(distribution.name(), distribution);
    }

    @Override
    public List<DistributionOption> allDistributionOptions() {
        return ((List<DistributionOption>) distributionMap);
    }

    @Override
    public List<DistributionCriterion> distributionOptionCriteria(String distributionName) {
        if (distributionMap.containsKey(distributionName.toUpperCase())) {
            return distributionMap.get(distributionName.toUpperCase()).criteria();
        } else {
            return new ArrayList<>();
        }
    }
}
