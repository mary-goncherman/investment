package com.invest.analitics.domain;

import java.util.List;

public interface AssetStorage {

    List<MonthTurnoverItem> getTurnover() throws AssetStorageException;
    List<AssetAllocation> getAssetAllocation() throws AssetStorageException;
    List<IndustryAllocation> getIndustryAllocation() throws AssetStorageException;
    List<CountryAllocation> getCountryAllocation() throws AssetStorageException;
    List<AverageBuyPrice> getAverageBuyPrices() throws AssetStorageException;
}
