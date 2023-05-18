drop database if exists `sprint_2.1`;
create database `sprint_2.1`;
use `sprint_2.1`;

create table role(
rode_id  int auto_increment primary key,
rode_name  varchar(45) 
);

create table account(
account_id   int auto_increment primary key,
email varchar(45),
name varchar(255),
flag_delete tinyint,
avatar varchar(255),
password varchar(255)
);

create table account_role(
account_id_role  int auto_increment primary key,
rode_id int, 
account_id int,
foreign key (account_id) references account(account_id),
foreign key (rode_id) references role(rode_id)
);

create table orders(
order_id  int auto_increment primary key,
delivery_status varchar(255), 
order_code varchar(255),
order_date varchar(255),
order_flag_delete bit(1),
account_id int,
quantity int,
foreign key (account_id) references account(account_id)
);

create table product_type(
product_type_id  bigint auto_increment primary key,
product_type_name varchar(255)
);

create table product(
product_id  int auto_increment primary key,
description varchar(255), 
product_code varchar(255),
product_flag_delete bit(1),
product_image varchar(255),
product_name varchar(255),
product_price int,
product_quatity int,
product_type_id bigint,
product_promotional_price bigint,
product_configuration int,
foreign key (product_type_id) references product_type(product_type_id)
);

create table images(
images_id  bigint auto_increment primary key,
product_id int,
image_name varchar(255),
image varchar(255),
foreign key (product_id) references product(product_id)
);

create table order_detail(
order_detail_id  int auto_increment primary key,
amount bigint, 
order_id int,
product_id int,
flag_delete bit(1),
flag_buy bit(1),
order_product_time datetime,
foreign key (order_id) references orders(order_id),
foreign key (product_id) references product(product_id)
);






