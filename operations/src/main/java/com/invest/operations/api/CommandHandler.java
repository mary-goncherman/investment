package com.invest.operations.api;

import com.invest.operations.service.OperationService;
import com.invest.operations.service.OperationServiceException;
import com.invest.operations.service.StockService;
import com.invest.operations.service.StockServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandHandler {

    private Logger logger = LoggerFactory.getLogger(CommandHandler.class);

    @Autowired
    private OperationService operationService;

    @Autowired
    private StockService stockService;

    public CommandHandler() {}

    public void completeOperation(CompleteOperationCommand command) throws CommandHandlerException {
        try {
            operationService.completeOperation(command.getStockCode(),
                    command.getStockAmount(),
                    command.getStockPrice(), command.getOperationTime(),
                    command.getOperationType(),
                    command.getCommission());
        } catch (OperationServiceException e) {
            throw new CommandHandlerException(e);
        }
    }

    public void createStock(CreateStockCommand command) throws CommandHandlerException {
        try {
            stockService.addStockIfNotExist(command.getStockCode(),
                    command.getOrganization(),
                    command.getAsset(),
                    command.getCurrencyName(),
                    command.getCurrencyCode(),
                    command.getCountryCode(),
                    command.getCountryName(),
                    command.getIndustryName());
        } catch (StockServiceException e) {
            throw new CommandHandlerException(e);
        }
    }
}
