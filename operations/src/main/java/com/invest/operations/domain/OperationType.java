package com.invest.operations.domain;

import java.util.Arrays;

public enum OperationType {

    BUY("Покупка"),
    SELL("Продажа");

    private String name;

    OperationType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static OperationType getByName(String name) {
        return Arrays.stream(OperationType.values())
                .filter(operation -> operation.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Некорректно указан вид операции!"));
    }
}
