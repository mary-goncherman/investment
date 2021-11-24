package com.invest.controller.stock;

import java.io.Serializable;

public class StockRequest implements Serializable {

    private String code;
    private String organization;
    private String asset;
    private String currencyCode;
    private String countryCode;
    private String industryId;

    public StockRequest() {}

    public StockRequest(String code, String organization, String asset, String currencyCode, String countryCode, String industryId) {
        this.code = code;
        this.organization = organization;
        this.asset = asset;
        this.currencyCode = currencyCode;
        this.countryCode = countryCode;
        this.industryId = industryId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getIndustryId() {
        return industryId;
    }

    public void setIndustryId(String industryId) {
        this.industryId = industryId;
    }
}
