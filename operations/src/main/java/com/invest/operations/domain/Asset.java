package com.invest.operations.domain;

import java.util.Arrays;

public enum Asset {

    GOLD("Золото"),
    BONDS("Облигации"),
    STOCK("Акции");

    private String name;

    Asset(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Asset getByName(String name) {
        return Arrays.stream(Asset.values())
                .filter(asset -> asset.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Некорректно указан вид распределения!"));
    }

}
