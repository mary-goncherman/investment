package com.invest.operations.service;

public class StockMetadata {

    private String currencyCode;
    private String countryCode;
    private String industryId;

    public StockMetadata() {}

    public StockMetadata(String currencyCode, String countryCode, String industryId) {
        this.currencyCode = currencyCode;
        this.countryCode = countryCode;
        this.industryId = industryId;
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
