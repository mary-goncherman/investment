package com.invest.operations.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "stock_data")
public class Stock implements Serializable {

    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "organization")
    private String organization;

    @Column(name = "asset")
    private String asset;

    @Column(name = "currency_code")
    private String currencyCode;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "industry_id")
    private String industryId;

    public Stock() {}

    private Stock(String code, String organization, String asset, String currencyCode, String countryCode, String industryId) {
        this.code = code;
        this.organization = organization;
        this.asset = asset;
        this.currencyCode = currencyCode;
        this.countryCode = countryCode;
        this.industryId = industryId;
    }

    public static Stock create(String code, String organization, String asset, String currencyCode, String countryCode, String industryId) {
        return new Stock(code, organization, Asset.getByName(asset).name(), currencyCode, countryCode, industryId);
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

