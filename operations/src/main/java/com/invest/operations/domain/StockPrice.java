package com.invest.operations.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@IdClass(StockPriceId.class)
@Table(name = "actual_prices")
public class StockPrice {

    @Id
    @Column(name = "period")
    private LocalDateTime period;

    @Id
    @Column(name = "stock_code")
    private String stockCode;

    @Column(name = "price")
    private float price;

    public StockPrice() {}

    public StockPrice(String stockCode, float price) {
        this.period = LocalDateTime.now();
        this.stockCode = stockCode;
        this.price = price;
    }

    public LocalDateTime getPeriod() {
        return period;
    }

    public void setPeriod(LocalDateTime period) {
        this.period = period;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
