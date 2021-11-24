package com.invest.controller.operation.imports;

import com.invest.operations.domain.OperationData;
import com.invest.operations.domain.StockData;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class XlsxFileParseService {

    private Logger logger = LoggerFactory.getLogger(XlsxFileParseService.class);

    private List<StockData> stockDataList = new ArrayList<>();
    private List<OperationData> operationDataList = new ArrayList<>();

    private static final int STOCK_CODE_CELL = 0;
    private static final int ORGANIZATION_CELL = 1;
    private static final int ASSET_CELL = 2;
    private static final int CURRENCY_CODE_CELL = 3;
    private static final int CURRENCY_NAME_CELL = 4;
    private static final int COUNTRY_CODE_CELL = 5;
    private static final int MARKET_CELL = 6;
    private static final int INDUSTRY_CELL = 7;
    private static final int STOCK_AMOUNT_CELL = 8;
    private static final int STOCK_PRICE_CELL = 9;
    //private static final int OPERATION_PRICE_CELL = 10;
    private static final int OPERATION_TYPE_CELL = 11;
    private static final int TIME_CELL = 12;
    private static final int COMMISSION_CELL = 13;

    public XlsxFileParseService() {
    }

    public List<StockData> getStockDataList() {
        return stockDataList;
    }

    public List<OperationData> getOperationDataList() {
        return operationDataList;
    }

    public void parseOperationsData(InputStream file) throws IOException {

        //FileInputStream file = new FileInputStream(new File("D:\\invest_project_files\\test.xlsx"));
        Workbook workbook = new XSSFWorkbook(file);

        Sheet sheet = workbook.getSheetAt(0);

        Iterator<Row> rows = sheet.rowIterator();
        skipRow(rows).forEachRemaining(
                row -> {
                    parseData(row);
                }
        );
    }

    private Iterator<Row> skipRow(Iterator<Row> rows) {
        rows.next();
        return rows;
    }

    private void parseData(Row row) {

        try {
            StockData stockData = new StockData();
            OperationData operationData = new OperationData();

            // проверка кода цб
            Cell stockCodeCell = row.getCell(STOCK_CODE_CELL);
            if (!isEmptyCell(stockCodeCell)) {
                String stockCode = stockCodeCell.getStringCellValue();
                logger.error("stockCode= " + stockCode);
                operationData.setStockCode(stockCode);
                stockData.setStockCode(stockCode);
            } else {
                //return Optional.empty();
            }

            // проверка организации
            Cell organizationCell = row.getCell(ORGANIZATION_CELL);
            if (!isEmptyCell(organizationCell)) {
                String organization = organizationCell.getStringCellValue();
                logger.error("organization= " + organization);
                stockData.setOrganization(organization);
            } else {
                //return Optional.empty();
            }

            // проверка распределения активов
            Cell assetCell = row.getCell(ASSET_CELL);
            if (!isEmptyCell(assetCell)) {
                String asset = assetCell.getStringCellValue();
                logger.error("asset= " + asset);
                stockData.setAsset(asset);
            } else {
                //return Optional.empty();
            }

            // проверка кода валюты
            Cell currencyCodeCell = row.getCell(CURRENCY_CODE_CELL);
            if (!isEmptyCell(currencyCodeCell)) {
                String currencyCode = currencyCodeCell.getStringCellValue();
                logger.error("currencyCode= " + currencyCode);
                stockData.setCurrencyCode(currencyCode);
            } else {
                //return Optional.empty();
            }

            // проверка наименования валюты
            Cell currencyNameCell = row.getCell(CURRENCY_NAME_CELL);
            if (!isEmptyCell(currencyNameCell)) {
                String currencyName = currencyNameCell.getStringCellValue();
                logger.error("currencyName= " + currencyName);
                stockData.setCurrencyName(currencyName);
            } else {
                //return Optional.empty();
            }

            // код страны(для определения рынка)
            Cell countryCodeCell = row.getCell(COUNTRY_CODE_CELL);
            if (!isEmptyCell(countryCodeCell)) {
                String countryCode = countryCodeCell.getStringCellValue();
                logger.error("countryCode= " + countryCode);
                stockData.setCountryCode(countryCode);
            }

            // страна
            Cell marketCell = row.getCell(MARKET_CELL);
            if (!isEmptyCell(marketCell)) {
                String market = marketCell.getStringCellValue();
                logger.error("market= " + market);
                stockData.setCountryName(market);
            }

            // отрасль (не обязательна)
            Cell industryCell = row.getCell(INDUSTRY_CELL);
            if (!isEmptyCell(industryCell)) {
                String industry = industryCell.getStringCellValue();
                logger.error("industry= " + industry);
                stockData.setIndustryName(industry);
            }

            // количество бумаг
            Cell stockAmountCell = row.getCell(STOCK_AMOUNT_CELL);
            if (!isEmptyCell(stockAmountCell)) {
                float stockAmount = (float) stockAmountCell.getNumericCellValue();
                logger.error("stockAmount= " + stockAmount);
                operationData.setStockAmount(stockAmount);
            } else {
                //return Optional.empty();
            }

            // цена одной цб
            Cell stockPriceCell = row.getCell(STOCK_PRICE_CELL);
            if (!isEmptyCell(stockPriceCell)) {
                float stockPrice = (float) stockPriceCell.getNumericCellValue();
                logger.error("stockPrice= " + stockPrice);
                operationData.setStockPrice(stockPrice);
            } else {
                //return Optional.empty();
            }

            // тип операции
            Cell operationTypeCell = row.getCell(OPERATION_TYPE_CELL);
            if (!isEmptyCell(operationTypeCell)) {
                String operationType = operationTypeCell.getStringCellValue();
                logger.error("operationType= " + operationType);
                operationData.setOperationType(operationType);
            } else {
                //return Optional.empty();
            }

            // время операции
            Cell timeCell = row.getCell(TIME_CELL);
            if (!isEmptyCell(timeCell)) {
                Date time = timeCell.getDateCellValue();
                LocalDateTime ldTime = Instant.ofEpochMilli(time.getTime())
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime();

                logger.error("ldTime= " + ldTime);
                operationData.setOperationTime(ldTime);
            } else {
                //return Optional.empty();
            }

            Cell commissionCell = row.getCell(COMMISSION_CELL);
            if (!isEmptyCell(commissionCell)) {
                float commission = (float) commissionCell.getNumericCellValue();
                logger.error("commission= " + commission);
                operationData.setCommission(commission);
            } else {
                //return Optional.empty();
            }

            stockDataList.add(stockData);
            operationDataList.add(operationData);

            } catch (Exception e) {
            //return Optional.empty();
        }

    }

    private boolean isEmptyCell(Cell cell) {
        return cell == null;
    }
}
