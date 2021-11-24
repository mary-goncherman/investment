package com.invest.application;

import com.invest.controller.stock.*;
import com.invest.operations.domain.Currency;
import com.invest.operations.domain.StockPrice;
import com.invest.operations.service.StockService;
import com.invest.operations.service.StockServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/stock")
public class StockResource {

    private Logger logger = LoggerFactory.getLogger(StockResource.class);

    @Autowired
    public StockService stockService;

    @PostMapping(path = "/currency/new", consumes = "application/json")
    public ResponseEntity<Object> addCurrency(@RequestBody CurrencyRequest currencyRequest) {
        try {
            stockService.addCurrency(currencyRequest.getCode(), currencyRequest.getName());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @GetMapping("/currency/all")
    public @ResponseBody ResponseEntity getAllCurrencies() {
        try {
            List<Currency> currencyList = stockService.getAllCurrencies();
            return new ResponseEntity<List<Currency>>(currencyList, HttpStatus.OK);
        } catch (StockServiceException e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @PostMapping(path = "/industry/new", consumes = "application/json")
    public ResponseEntity<Object> addIndustry(@RequestBody IndustryRequest industryRequest) {
        try {
            String industryId = stockService.addIndustry(industryRequest.getName());
            return ResponseEntity.ok(industryId);
        } catch (StockServiceException e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @PostMapping(path = "/market/new", consumes = "application/json")
    public ResponseEntity<Object> addMarket(@RequestBody MarketRequest marketRequest) {
        try {
            stockService.addMarket(marketRequest.getCode(), marketRequest.getName());
            return ResponseEntity.ok().build();
        } catch (StockServiceException e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @PostMapping(path = "/new", consumes = "application/json")
    public ResponseEntity<Object> addStock(@RequestBody StockRequest stockRequest) {
        try {
            stockService.addStock(stockRequest.getCode(),
                    stockRequest.getOrganization(),
                    stockRequest.getAsset(),
                    stockRequest.getCurrencyCode(),
                    stockRequest.getCountryCode(),
                    stockRequest.getIndustryId());
            return ResponseEntity.ok().build();
        } catch (StockServiceException e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @PostMapping(path = "/set/actual_prices", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> setActualPrices(@RequestBody List<StockPriceRequest> stockPriceRequestList) {
        try {
            stockService.setActualPrices(stockPriceListFromRequest(stockPriceRequestList));
            return ResponseEntity.ok().build();
        } catch (StockServiceException e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }

    private List<StockPrice> stockPriceListFromRequest(List<StockPriceRequest> stockPriceRequestList) {
        List<StockPrice> stockPriceList = new ArrayList<>();
        for (StockPriceRequest request : stockPriceRequestList) {
            stockPriceList.add(new StockPrice(request.getStockCode(), request.getPrice()));
        }
        return stockPriceList;
    }

}
