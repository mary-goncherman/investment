package com.invest.controller.operation;

import com.invest.controller.operation.imports.XlsxFileParseService;
import com.invest.operations.domain.Operation;
import com.invest.operations.domain.OperationData;
import com.invest.operations.domain.StockData;
import com.invest.operations.service.OperationService;
import com.invest.operations.service.OperationServiceException;
import com.invest.operations.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/operation")
public class OperationResource {

    private Logger logger = LoggerFactory.getLogger(OperationResource.class);

    @Autowired
    public OperationService operationService;

    @Autowired
    public StockService stockService;

    @Autowired
    public XlsxFileParseService xlsxFileParseService;

    @PostMapping(path = "/new", consumes = "application/json")
    public ResponseEntity<Object> addOperation(@RequestBody OperationRequest operationRequest) {
        try {
            System.out.println(operationRequest.getCommission());
            operationService.completeOperation(
                    operationRequest.getStockCode(),
                    operationRequest.getStockAmount(),
                    operationRequest.getStockPrice(),
                    operationRequest.getOperationTime(),
                    operationRequest.getOperationType(),
                    operationRequest.getCommission());
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (OperationServiceException e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @PostMapping(path = "/import")
    public void importOperationsXlsx(@RequestParam("file") MultipartFile files) {
        try {
            xlsxFileParseService.parseOperationsData(files.getInputStream());

            List<StockData> stockDataList = xlsxFileParseService.getStockDataList();
            stockService.addOnlyNewStocks(stockDataList);

            List<OperationData> operationDataList = xlsxFileParseService.getOperationDataList();
            operationService.completeOperations(operationDataList);

        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }

    @GetMapping(path = "/for/stock")
    public ResponseEntity<Object> getStockOperations(@RequestParam("code") String stockCode) {
        try {
            List<Operation> operations = operationService.getStockOperations(stockCode);
            return ResponseEntity.status(HttpStatus.OK).body(operations);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(path = "/high/commission")
    public ResponseEntity<Object> getStockWithHighCommission(@RequestParam("level") float level) {
        try {
            List<Operation> operations = operationService.excessCommissionOperations(level);
            return ResponseEntity.status(HttpStatus.OK).body(operations);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(path = "/in/period")
    public ResponseEntity<Object> getStockOperationsInPeriod(@RequestBody OperationInPeriodRequest operationRequest) {
        try {
            List<Operation> operations = operationService.operationsInPeriod(operationRequest.getStartDate(), operationRequest.getEndDate());
            return ResponseEntity.status(HttpStatus.OK).body(operations);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(path = "/lot_of_stocks")
    public ResponseEntity<Object> aLotStockOperation(@RequestParam("stockAmount") float stockAmount) {
        try {
            List<Operation> operations = operationService.aLotStockOperation(stockAmount);
            return ResponseEntity.status(HttpStatus.OK).body(operations);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}
