package com.invest.analitics.service;

import com.invest.analitics.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PortfolioAnaliticService {

    private AssetStorage assetStorage;

    @Autowired
    public PortfolioAnaliticService(AssetStorage assetStorage) {
        this.assetStorage = assetStorage;
    }

    public List<MonthTurnoverItem> getTurnoverByMonths() throws AnaliticServiceException {
        try {
            return assetStorage.getTurnover();
        } catch (AssetStorageException e) {
            throw new AnaliticServiceException(e);
        }
    }

    public List<AllocationResult> getAssetAllocation() throws AnaliticServiceException {
        try {
            List<AllocationResult> allocationResults = new ArrayList<>();
            List<AssetAllocation> assetAllocations = assetStorage.getAssetAllocation();
            float totalPortfolioPrice = assetAllocations.stream().map(AssetAllocation::getPrice).reduce((float) 0, Float::sum);

            for (AssetAllocation assetAllocation : assetAllocations) {
                allocationResults.add(new AllocationResult(assetAllocation.getAsset(), (assetAllocation.getPrice()/totalPortfolioPrice*100)));
            }
            return allocationResults;
        } catch (AssetStorageException e) {
            throw new AnaliticServiceException(e);
        }
    }

    public List<AllocationResult> getIndustryAllocation() throws AnaliticServiceException {
        try {
            List<AllocationResult> allocationResults = new ArrayList<>();
            List<CountryAllocation> countryAllocations = assetStorage.getCountryAllocation();
            float totalRussianStockPrice = countryAllocations.stream()
                    .filter(countryAllocation -> countryAllocation.getCountry().equals("RUS"))
                    .map(CountryAllocation::getPrice)
                    .reduce((float) 0, Float::sum);

            List<IndustryAllocation> industryAllocations = assetStorage.getIndustryAllocation();

            for (IndustryAllocation industryAllocation : industryAllocations) {
                allocationResults.add(new AllocationResult(industryAllocation.getIndustry(), (industryAllocation.getPrice()/totalRussianStockPrice*100)));
            }
            return allocationResults;
        } catch (AssetStorageException e) {
            throw new AnaliticServiceException(e);
        }
    }

    public List<AllocationResult> getCountryAllocation() throws AnaliticServiceException {
        try {
            List<AllocationResult> allocationResults = new ArrayList<>();
            List<AssetAllocation> assetAllocations = assetStorage.getAssetAllocation();
            float totalStockPrice = assetAllocations.stream()
                    .filter(assetAllocation -> assetAllocation.getAsset().equals("STOCK"))
                    .map(AssetAllocation::getPrice)
                    .reduce((float) 0, Float::sum);

            List<CountryAllocation> countryAllocations = assetStorage.getCountryAllocation();

            for (CountryAllocation countryAllocation : countryAllocations) {
                allocationResults.add(new AllocationResult(countryAllocation.getCountry(), (countryAllocation.getPrice()/totalStockPrice*100)));
            }
            return allocationResults;
        } catch (AssetStorageException e) {
            throw new AnaliticServiceException(e);
        }
    }

    public List<AverageBuyPrice> getAverageBuyPrice() throws AnaliticServiceException {
        try {
            return assetStorage.getAverageBuyPrices();
        } catch (AssetStorageException e) {
            throw new AnaliticServiceException(e);
        }
    }

}
