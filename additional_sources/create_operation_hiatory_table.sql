CREATE TABLE operation_history
(id varchar(36) not null,
stock_code varchar(10) not null,
stock_amount numeric(10,2) not null,
stock_price numeric(10,2) not null,
operation_price numeric(10,2) not null,
operation_time dateTime not null,
operation_type varchar(10) not null,
commission numeric(10,2) not null,
PRIMARY KEY (id));