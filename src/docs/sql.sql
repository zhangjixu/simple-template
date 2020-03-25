create table `order`
(
  id       int auto_increment
    primary key,
  order_id int          null,
  goods    varchar(100) null,
  price    float        null
);