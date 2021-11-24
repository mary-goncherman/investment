package com.invest.operations.service;

import com.invest.operations.domain.*;
import com.invest.operations.infrastructure.StockStorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    private StockStorage stockStorage;

    public StockService() {}

    @Autowired
    public StockService(StockStorage stockStorage) {
        this.stockStorage = stockStorage;
    }

    public void addCurrency(String code, String name) throws StockServiceException {
        try {
            Currency currency = new Currency(code, name);
            stockStorage.addCurrency(currency);
        } catch (StockStorageException e) {
            throw new StockServiceException(e);
        }
    }

    public Currency getCurrency(String code) throws StockServiceException {
        try {
            return stockStorage.findCurrencyByCode(code);
        } catch (StockStorageException e) {
            throw new StockServiceException(e);
        }
    }

    public String addIndustry(String name) throws StockServiceException {
        try {
            if ((name == null) || (name.isEmpty())) {
                throw new StockServiceException("Не указано название отрасли");
            }
            if (stockStorage.findIndustryByName(name).isPresent()) {
                throw new StockServiceException("Данная отрасль уже есть в базе данных");
            }
            Industry industry = Industry.create(name);
            stockStorage.addIndustry(industry);
            return industry.getId();
        } catch (StockStorageException e) {
            throw new StockServiceException(e);
        }
    }

    public Industry getIndustry(String id) throws StockServiceException {
        try {
            return stockStorage.findIndustryById(id);
        } catch (StockStorageException e) {
            throw new StockServiceException(e);
        }
    }

    public void addMarket(String code, String name) throws StockServiceException {
        try {
            Market market = new Market(code, name);
            stockStorage.addMarket(market);
        } catch (StockStorageException e) {
            throw new StockServiceException(e);
        }
    }

    public Optional<Market> getMarket(String code) throws StockServiceException {
        try {
            return stockStorage.findMarketByCode(code);
        } catch (StockStorageException e) {
            throw new StockServiceException(e);
        }
    }

    public void addStock(String code, String organization, String asset, String currencyCode, String marketCode, String industryId) throws StockServiceException {
        try {
            if (stockExists(code)) {
                throw new StockServiceException("В системе уже есть ценная бумага с указанным тикером");
            }
            Stock stock = Stock.create(code, organization, asset, currencyCode, marketCode, industryId);
            stockStorage.addStock(stock);
        } catch (StockStorageException e) {
            throw new StockServiceException(e);
        }
    }

    public void addOnlyNewStocks(List<StockData> stockDataList) throws StockServiceException {
        for (StockData stockData : stockDataList) {
            addStockIfNotExist(stockData.getStockCode(),
                    stockData.getOrganization(),
                    stockData.getAsset(),
                    stockData.getCurrencyName(),
                    stockData.getCurrencyCode(),
                    stockData.getCountryCode(),
                    stockData.getCountryName(),
                    stockData.getIndustryName());
        }
    }

    public void addStockIfNotExist(
            String stockCode, String organization, String asset, String currencyName, String currencyCode, String countryCode, String countryName, String industryName)
            throws StockServiceException {
        if (!stockExists(stockCode)) {
            StockMetadata stockMetadata = addStockMetadata(currencyCode,
                    currencyName,
                    countryCode,
                    countryName,
                    industryName);
            addStock(stockCode,
                    organization,
                    asset,
                    stockMetadata.getCurrencyCode(),
                    stockMetadata.getCountryCode(),
                    stockMetadata.getIndustryId());
        }
    }

    public boolean stockExists(String code) throws StockServiceException {
        try {
            return (stockStorage.findStockByCode(code) != null);
        } catch (StockStorageException e) {
            throw new StockServiceException(e);
        }
    }

    public StockMetadata addStockMetadata(String currencyCode, String currencyName, String countryCode, String countryName, String industryName) throws StockServiceException {
        try {
            StockMetadata metadata = new StockMetadata();
            if (getCurrency(currencyCode) == null) {
                stockStorage.addCurrency(new Currency(currencyCode, currencyName));
            }
            metadata.setCurrencyCode(currencyCode);

            if ((countryCode != null) && (!countryCode.isEmpty())) {
                Optional<Market> marketOptional = stockStorage.findMarketByCode(countryCode);
                if (!marketOptional.isPresent()) {
                    stockStorage.addMarket(new Market(countryCode, countryName));
                }
                metadata.setCountryCode(countryCode);
            }

            if ((industryName != null) && (!industryName.isEmpty())) {
                Optional<Industry> industryOptional = stockStorage.findIndustryByName(industryName);
                if (industryOptional.isPresent()) {
                    metadata.setIndustryId(industryOptional.get().getId());
                } else {
                    String industryId = addIndustry(industryName);
                    metadata.setIndustryId(industryId);
                }
            }

            return metadata;
        } catch (StockStorageException e) {
            throw new StockServiceException(e);
        }
    }

    public List<Currency> getAllCurrencies() throws StockServiceException {
        try {
            return stockStorage.findAllCurrencies();
        } catch (StockStorageException e) {
            throw new StockServiceException(e);
        }

    }

    public void setActualPrices(List<StockPrice> stockPriceList) throws StockServiceException {
        try {
            stockStorage.setActualPrices(stockPriceList);
        } catch (StockStorageException e) {
            throw new StockServiceException(e);
        }
    }


}
