drop table product;

drop sequence product_pkey_sequence;

create table product
(
  id          bigint PRIMARY KEY,
  name        varchar(200),
  description varchar(1024),
  image_id    varchar(100)
);

CREATE SEQUENCE product_pkey_sequence START 1;
