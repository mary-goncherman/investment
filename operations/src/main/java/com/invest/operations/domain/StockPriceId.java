package com.invest.operations.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class StockPriceId implements Serializable {

    private LocalDateTime period;
    private String stockCode;

    public StockPriceId() {}

    public StockPriceId(LocalDateTime period, String stockCode) {
        this.period = period;
        this.stockCode = stockCode;
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof StockPriceId))
            return false;
        StockPriceId other = (StockPriceId)o;
        boolean stockCodeIdEquals = ((this.stockCode == null) && (other.stockCode == null)) || (this.stockCode.equals(other.stockCode));
        boolean periodIdEquals = ((this.period == null) && (other.period == null)) || (this.period.equals(other.period));
        return stockCodeIdEquals && periodIdEquals;
    }

    @Override
    public int hashCode() {
        int result = 1234;
        if (stockCode != null) {
            result = 28 * result + stockCode.hashCode();
        }
        if (period != null) {
            result = 28 * result + period.hashCode();
        }
        return result;
    }
}
