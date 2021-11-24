package com.invest.analitics.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "average_buy_price")
public class AverageBuyPrice implements Serializable {

    @Id
    @Column(name = "organization")
    private String organization;

    @Column(name = "current_price")
    private float currentPrice;

    @Column(name = "average_buy_price")
    private float averageBuyPrice;

    public AverageBuyPrice() {}

    public AverageBuyPrice(String organization, float currentPrice, float averageBuyPrice) {
        this.organization = organization;
        this.currentPrice = currentPrice;
        this.averageBuyPrice = averageBuyPrice;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public float getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(float currentPrice) {
        this.currentPrice = currentPrice;
    }

    public float getAverageBuyPrice() {
        return averageBuyPrice;
    }

    public void setAverageBuyPrice(float averageBuyPrice) {
        this.averageBuyPrice = averageBuyPrice;
    }
}
