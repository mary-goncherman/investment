CREATE TABLE criteria
(id varchar(36) not null,
name varchar(50) not null,
distribution varchar(50) not null,
main_criteria_id varchar(36),
priority numeric(10,0) not null,
PRIMARY KEY (id));