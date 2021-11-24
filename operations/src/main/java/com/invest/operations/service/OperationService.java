package com.invest.operations.service;

import com.invest.operations.domain.Operation;
import com.invest.operations.domain.OperationData;
import com.invest.operations.domain.OperationStorage;
import com.invest.operations.domain.OperationType;
import com.invest.operations.infrastructure.OperationStorageException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OperationService {

    private Logger logger = LoggerFactory.getLogger(OperationService.class);

    @Autowired
    private OperationStorage operationStorage;

    @Autowired
    private StockService stockService;

    public OperationService() {}

    public void completeOperations(List<OperationData> operationDataList) throws OperationServiceException {

        for (OperationData operationData : operationDataList) {
            completeOperation(operationData.getStockCode(),
                    operationData.getStockAmount(),
                    operationData.getStockPrice(),
                    operationData.getOperationTime(),
                    operationData.getOperationType(),
                    operationData.getCommission());
        }

    }

    public void completeOperation(String stockCode,
                                  float stockAmount,
                                  float stockPrice,
                                  LocalDateTime operationTime,
                                  String operationType,
                                  float commission) throws OperationServiceException {
        try {
            if (!stockService.stockExists(stockCode)) {
                throw new OperationServiceException("Ценной бумаги с указанным тикером нет в базе!");
            }
            complete(stockCode, stockAmount, stockPrice, operationTime, operationType, commission);
        } catch (StockServiceException e) {
            throw new OperationServiceException(e.getMessage());
        }
    }

    private void complete(String stockCode,
                          float stockAmount,
                          float stockPrice,
                          LocalDateTime operationTime,
                          String operationType,
                          float commission) throws OperationServiceException {
        try {
            Operation operation =
                    Operation.create(stockCode, stockAmount, stockPrice, operationTime, OperationType.getByName(operationType), commission);
            if (!operationStorage.operationExists(operation.getStockCode(), operation.getOperationTime())) {
                operationStorage.save(operation);
            }
        } catch (OperationStorageException e) {
            throw new OperationServiceException(e.getMessage());
        }
    }

    public List<Operation> getStockOperations(String stockCode) {
        return operationStorage.findByStockCode(stockCode);
    }

    public List<Operation> excessCommissionOperations(float commission) {
        return operationStorage.findByCommissionGreaterThanOrderByOperationTime(commission);
    }

    public List<Operation> operationsInPeriod(LocalDateTime startDate, LocalDateTime endDate) {
        return operationStorage.findByOperationTimeBetween(startDate, endDate);
    }

    public List<Operation> aLotStockOperation(float stockAmount) {
        return operationStorage.getBigAmountStockOperations(stockAmount);
    }

}
