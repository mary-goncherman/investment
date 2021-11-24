package com.invest.operations.domain;

public class StockData {

    private String stockCode;
    private String organization;
    private String asset;
    private String currencyCode;
    private String currencyName;
    private String countryCode;
    private String countryName;
    private String industryName;

    public StockData() {}

    public StockData(String stockCode, String organization, String asset, String currencyCode, String currencyName, String countryCode, String countryName, String industryName) {
        this.stockCode = stockCode;
        this.organization = organization;
        this.asset = asset;
        this.currencyCode = currencyCode;
        this.currencyName = currencyName;
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.industryName = industryName;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
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

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }
}
