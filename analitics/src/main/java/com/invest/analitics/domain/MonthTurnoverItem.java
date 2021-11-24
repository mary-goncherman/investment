package com.invest.analitics.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@IdClass(TurnoverItemId.class)
@Table(name = "month_turnover")
public class MonthTurnoverItem {

    @Id
    @Column(name = "period")
    private LocalDateTime period;

    @Id
    @Column(name = "operation_type")
    private String operationType;

    @Column(name = "sum")
    private float sum;

    @Column(name = "commission")
    private float commission;

    public MonthTurnoverItem() {}

    public MonthTurnoverItem(LocalDateTime period, String operationType, float sum, float commission) {
        this.period = period;
        this.operationType = operationType;
        this.sum = sum;
        this.commission = commission;
    }

    public LocalDateTime getPeriod() {
        return period;
    }

    public void setPeriod(LocalDateTime period) {
        this.period = period;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }
}
