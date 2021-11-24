package com.invest.operations.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OperationStorage extends CrudRepository<Operation, String>, ExtraOperationStorageData {

    List<Operation> findByStockCode(String stockCode);

    List<Operation> findByCommissionGreaterThanOrderByOperationTime(float commission);

    List<Operation> findByOperationTimeBetween(LocalDateTime startDate, LocalDateTime endDate);

    @Query("select operation from Operation operation where operation.stockAmount >= ?1")
    //, nativeQuery = true) - добавить для SQL-запросов
    List<Operation> getBigAmountStockOperations(float stockAmount);
}
