package com.invest.controller.stock;

import java.io.Serializable;

public class CurrencyRequest implements Serializable {

    private String code;
    private String name;

    public CurrencyRequest() {}

    public CurrencyRequest(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
