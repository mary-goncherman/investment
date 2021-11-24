package com.invest.controller.operation;

import java.time.LocalDateTime;

public class OperationInPeriodRequest {
    public LocalDateTime startDate;

    public LocalDateTime endDate;

    public OperationInPeriodRequest(LocalDateTime startDate, LocalDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
