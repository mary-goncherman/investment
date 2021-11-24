package com.invest.controller.stock;

import java.io.Serializable;

public class IndustryRequest implements Serializable {

    private String name;

    public IndustryRequest() {}

    public IndustryRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
