package com.invest.analitics.infrastructure;

import com.invest.analitics.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class JpaAssetStorage implements AssetStorage {

    private Logger logger = LoggerFactory.getLogger(JpaAssetStorage.class);

    @Autowired
    private EntityManager em;

    @Override
    public List<MonthTurnoverItem> getTurnover() throws AssetStorageException {
        try {
            List<MonthTurnoverItem> result =
                    em.createQuery("select item from MonthTurnoverItem item", MonthTurnoverItem.class)
                            .getResultList();

            return result;
        } catch (Exception e) {
            logger.error("Ошибка запроса помесячного распределения активов");
            throw new AssetStorageException(e);
        }
    }

    @Override
    public List<AssetAllocation> getAssetAllocation() throws AssetStorageException {
        try {
            List<AssetAllocation> result =
                    em.createQuery("select allocation from AssetAllocation allocation", AssetAllocation.class)
                            .getResultList();

            return result;
        } catch (Exception e) {
            logger.error("Ошибка запроса распределения средств по видам активов");
            throw new AssetStorageException(e);
        }
    }

    @Override
    public List<IndustryAllocation> getIndustryAllocation() throws AssetStorageException {
        try {
            List<IndustryAllocation> result =
                    em.createQuery("select industryAllocation from IndustryAllocation industryAllocation", IndustryAllocation.class)
                            .getResultList();

            return result;
        } catch (Exception e) {
            logger.error("Ошибка запроса помесячного распределения активов");
            throw new AssetStorageException(e);
        }
    }

    @Override
    public List<CountryAllocation> getCountryAllocation() throws AssetStorageException {
        try {
            List<CountryAllocation> result =
                    em.createQuery("select countryAllocation from CountryAllocation countryAllocation", CountryAllocation.class)
                            .getResultList();

            return result;
        } catch (Exception e) {
            logger.error("Ошибка запроса помесячного распределения активов");
            throw new AssetStorageException(e);
        }
    }

    @Override
    public List<AverageBuyPrice> getAverageBuyPrices() throws AssetStorageException {
        try {
            List<AverageBuyPrice> result =
                    em.createQuery("select averagePrice from AverageBuyPrice averagePrice", AverageBuyPrice.class)
                            .getResultList();
            return result;
        } catch (Exception e) {
            logger.error("Ошибка запроса средней цены покупки");
            throw new AssetStorageException(e);
        }
    }
}
