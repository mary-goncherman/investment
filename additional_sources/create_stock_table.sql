CREATE TABLE stock_data
    (code varchar(10) not null,
    organization varchar(50) not null,
    asset varchar(20) not null,
    currency_code varchar(10) not null,
    country_code varchar(10),
    industry_id varchar(36),
PRIMARY KEY (code));