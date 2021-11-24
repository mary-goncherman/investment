CREATE TABLE portfolio_distribution
(id varchar(36) not null,
portfolio_id varchar(36) not null,
criteria_id varchar(36) not null,
per_cent numeric not null,
deleted bit not null,
PRIMARY KEY (id));