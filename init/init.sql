create table product(
  id bigint PRIMARY KEY,
  name varchar(200),
  description varchar(1024)
);

CREATE SEQUENCE product_pkey_sequence START 1;