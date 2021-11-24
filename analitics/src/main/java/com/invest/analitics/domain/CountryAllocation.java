package com.invest.analitics.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "country_allocation")
public class CountryAllocation implements Serializable {

    @Id
    @Column(name = "country_code")
    private String country;

    @Column(name = "price")
    private float price;

    public CountryAllocation() {}

    public CountryAllocation(String country, float price) {
        this.country = country;
        this.price = price;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
