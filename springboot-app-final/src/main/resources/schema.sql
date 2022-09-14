drop table if exists customer;
create table customer 
(
	customer_id bigint not null AUTO_INCREMENT,
	first_name varchar(25) not null, 
	last_name varchar(25) not null, 
	age integer, 
	ssn integer not null,
	last_updated_by varchar(25),
	created datetime not null,  
	updated datetime not null, 
	primary key (customer_id),
	CONSTRAINT cust_uniquee UNIQUE (ssn)
) 
-- engine=InnoDB;
