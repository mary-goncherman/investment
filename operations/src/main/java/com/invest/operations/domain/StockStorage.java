package com.invest.operations.domain;

import com.invest.operations.infrastructure.StockStorageException;

import java.util.List;
import java.util.Optional;

public interface StockStorage {

    void addCurrency(Currency currency) throws StockStorageException;
    Currency findCurrencyByCode(String code) throws StockStorageException;
    Currency findCurrencyByName(String name);

    void addIndustry(Industry industry) throws StockStorageException;
    Industry findIndustryById(String id) throws StockStorageException;
    Optional<Industry> findIndustryByName(String name) throws StockStorageException;

    void addMarket(Market market) throws StockStorageException;
    Optional<Market> findMarketByCode(String code) throws StockStorageException;
    Market findMarketByName(String name);

    void addStock(Stock stock) throws StockStorageException;
    Stock findStockByCode(String code) throws StockStorageException;

    List<Currency> findAllCurrencies() throws StockStorageException;

    void setActualPrices(List<StockPrice> stockPriceList) throws StockStorageException;
}
