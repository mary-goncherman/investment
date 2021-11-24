package com.invest.operations.infrastructure;

import com.invest.operations.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class JpaStockStorage implements StockStorage {

    private Logger logger = LoggerFactory.getLogger(JpaStockStorage.class);

    @Autowired
    private EntityManager em;

    @Override
    public void addCurrency(Currency currency) throws StockStorageException {
        try {
            em.persist(currency);
        } catch (Exception e) {
            throw new StockStorageException(e.getMessage());
        }
    }

    @Override
    public Currency findCurrencyByCode(String code) throws StockStorageException {
        try {
            return em.find(Currency.class, code);
        } catch (Exception e) {
            throw new StockStorageException(e.getMessage());
        }
    }

    @Override
    public Currency findCurrencyByName(String name) {
        return null;
    }

    @Override
    public void addIndustry(Industry industry) throws StockStorageException {
        try {
            em.persist(industry);
        } catch (Exception e) {
            throw new StockStorageException(e.getMessage());
        }
    }

    @Override
    public Industry findIndustryById(String id) throws StockStorageException {
        try {
            return em.find(Industry.class, id);
        } catch (Exception e) {
            throw new StockStorageException(e.getMessage());
        }
    }

    @Override
    public Optional<Industry> findIndustryByName(String name) throws StockStorageException {
        try {
            return em.createQuery("select industry from Industry industry where industry.name = :name", Industry.class)
                    .setParameter("name", name)
                    .getResultList()
                    .stream().findFirst();
        } catch (Exception e) {
            throw new StockStorageException(e.getMessage());
        }
    }

    @Override
    public void addMarket(Market market) throws StockStorageException {
        try {
            em.persist(market);
        } catch (Exception e) {
            throw new StockStorageException(e.getMessage());
        }
    }

    @Override
    public Optional<Market> findMarketByCode(String code) throws StockStorageException {
        try {
            return em.createQuery("select market from Market market where market.countryCode = :code", Market.class)
                    .setParameter("code", code)
                    .getResultList()
                    .stream().findFirst();
        } catch (Exception e) {
            throw new StockStorageException(e.getMessage());
        }
    }

    @Override
    public Market findMarketByName(String name) {
        return null;
    }

    @Override
    public void addStock(Stock stock) throws StockStorageException {
        try {
            em.persist(stock);
        } catch (Exception e) {
            throw new StockStorageException(e.getMessage());
        }
    }

    @Override
    public Stock findStockByCode(String code) throws StockStorageException {
        try {
            return em.find(Stock.class, code);
        } catch (Exception e) {
            throw new StockStorageException(e.getMessage());
        }
    }

    @Override
    public List<Currency> findAllCurrencies() throws StockStorageException {
        try {
            return em.createQuery("select currency from Currency currency", Currency.class)
                    .getResultList();
        } catch (Exception e) {
            throw new StockStorageException(e.getMessage());
        }
    }

    @Override
    public void setActualPrices(List<StockPrice> stockPriceList) throws StockStorageException {
        try {
            for (StockPrice stockPrice : stockPriceList) {
                em.persist(stockPrice);
            }
        } catch (Exception e) {
            throw new StockStorageException(e.getMessage());
        }
    }
}
