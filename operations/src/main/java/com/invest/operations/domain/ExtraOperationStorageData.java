package com.invest.operations.domain;

import com.invest.operations.infrastructure.OperationStorageException;

import java.time.LocalDateTime;

public interface ExtraOperationStorageData {
    boolean operationExists(String stockCode, LocalDateTime operationTime) throws OperationStorageException;
    //findByStockCodeEqualsAndOperationTimeEquals
}
