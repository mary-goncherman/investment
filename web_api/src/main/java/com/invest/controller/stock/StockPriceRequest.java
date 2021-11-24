package com.invest.controller.stock;

public class StockPriceRequest {

    private String stockCode;
    private float price;

    public StockPriceRequest(String stockCode, float price) {
        this.stockCode = stockCode;
        this.price = price;
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
