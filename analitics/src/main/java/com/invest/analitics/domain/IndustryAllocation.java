package com.invest.analitics.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "industry_allocation")
public class IndustryAllocation implements Serializable {

    @Id
    @Column(name = "industry")
    private String industry;

    @Column(name = "price")
    private float price;

    public IndustryAllocation() {}

    public IndustryAllocation(String industry, float price) {
        this.industry = industry;
        this.price = price;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
