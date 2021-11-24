package com.invest.analitics.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class TurnoverItemId implements Serializable {

    private LocalDateTime period;
    private String operationType;

    public TurnoverItemId() {}

    public TurnoverItemId(LocalDateTime period, String operationType) {
        this.period = period;
        this.operationType = operationType;
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TurnoverItemId))
            return false;
        TurnoverItemId other = (TurnoverItemId)o;
        boolean periodEquals = ((this.period == null) && (other.period == null)) || (this.period.isEqual(other.period));
        boolean operationTypeEquals =
                ((this.operationType == null) && (other.operationType == null)) || (this.operationType.equals(other.operationType));
        return periodEquals && operationTypeEquals;
    }

    @Override
    public int hashCode() {
        int result = operationType.hashCode();
        if (period != null) {
            result = 28 * result + period.hashCode();
        }

        return result;
    }
}
