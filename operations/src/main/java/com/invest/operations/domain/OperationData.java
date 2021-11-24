package com.invest.operations.domain;

import java.time.LocalDateTime;

public class OperationData {

    private String stockCode;
    private float stockAmount;
    private float stockPrice;
    private LocalDateTime operationTime;
    private String operationType;
    private float commission;

    public OperationData() {}

    public OperationData(String stockCode, float stockAmount, float stockPrice, LocalDateTime operationTime, String operationType, float commission) {
        this.stockCode = stockCode;
        this.stockAmount = stockAmount;
        this.stockPrice = stockPrice;
        this.operationTime = operationTime;
        this.operationType = operationType;
        this.commission = commission;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public float getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(float stockAmount) {
        this.stockAmount = stockAmount;
    }

    public float getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(float stockPrice) {
        this.stockPrice = stockPrice;
    }

    public LocalDateTime getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(LocalDateTime operationTime) {
        this.operationTime = operationTime;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }
}
