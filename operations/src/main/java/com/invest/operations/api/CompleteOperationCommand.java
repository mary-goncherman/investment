package com.invest.operations.api;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CompleteOperationCommand {

    public String stockCode;
    public float stockAmount;
    public float stockPrice;
    public LocalDateTime operationTime;
    public String operationType;
    public float commission;
}
