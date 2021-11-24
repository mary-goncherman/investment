package com.invest.operations.api;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateStockCommand {
    public String stockCode;
    public String organization;
    public String asset;
    public String currencyCode;
    public String currencyName;
    public String countryCode;
    public String countryName;
    public String industryName;
}
