package com.invest.operations.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "operation_history")
public class Operation implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "stock_code")
    private String stockCode;

    @Column(name = "stock_amount")
    private float stockAmount;

    @Column(name = "stock_price")
    private float stockPrice;

    @Column(name = "operation_price")
    private float operationPrice;

    @Column(name = "operation_time")
    private LocalDateTime operationTime;

    @Column(name = "operation_type")
    private String operationType;

    @Column(name = "commission")
    private float commission;

    public Operation() {}

    private Operation(String id,
                     String stockCode,
                      float stockAmount,
                      float stockPrice,
                      float operationPrice,
                     LocalDateTime operationTime,
                     String operationType,
                      float commission) {
        this.id = id;
        this.stockCode = stockCode;
        this.stockAmount = stockAmount;
        this.stockPrice = stockPrice;
        this.operationPrice = operationPrice;
        this.operationTime = operationTime;
        this.operationType = operationType;
        this.commission = commission;
    }

    public static Operation create(String stockCode,
                                   float stockAmount,
                                   float stockPrice,
                                   LocalDateTime operationTime,
                                   OperationType operationType,
                                   float commission) {
        return new Operation(UUID.randomUUID().toString(),
                stockCode,
                stockAmount,
                stockPrice,
                stockAmount * stockPrice,
                operationTime,
                operationType.name(),
                commission);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public float getOperationPrice() {
        return operationPrice;
    }

    public void setOperationPrice(float operationPrice) {
        this.operationPrice = operationPrice;
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
