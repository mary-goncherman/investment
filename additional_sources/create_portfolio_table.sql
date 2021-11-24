CREATE TABLE portfolio
(id varchar(36) not null,
name varchar(50) not null,
target_amount numeric not null,
horizont dateTime not null,
main_portfolio_id varchar(36),
PRIMARY KEY (id));