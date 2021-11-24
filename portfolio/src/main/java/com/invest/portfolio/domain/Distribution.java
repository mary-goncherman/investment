package com.invest.portfolio.domain;

import java.util.Arrays;
import java.util.HashMap;

public enum Distribution {

    ASSET("ASSET",   "Распределение по видам активов"),
    CURRENCY("CURRENCY", "Валютное распределение"),
    MARKET("MARKET", "Страновое распределение"),
    INDUSTRY("INDUSTRY",  "Распределение по отраслям"),
    BROKER("BROKER", "Диверсификация по типу брокера");

    private String name;
    private String description;

    Distribution(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static Distribution getByName(String name) {
        return Arrays.stream(Distribution.values())
                .filter(distribution -> distribution.name().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Некорректно указан вид распределения!"));
    }

    public static Distribution getDistributionLevels(Integer level) {
        HashMap<Integer, Distribution> distributionLevels = new HashMap<>();
        distributionLevels.put(1, Distribution.ASSET);
        distributionLevels.put(2, Distribution.MARKET);
        distributionLevels.put(3, Distribution.INDUSTRY);

        if (distributionLevels.containsKey(level)) {
            return distributionLevels.get(level);
        } else {
            throw new IllegalArgumentException("Данного уровня распределения нет в системе");
        }
    }
}
