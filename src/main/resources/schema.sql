-- drop database sportyshoes;
-- create database sportyshoes;
-- use sportyshoes;

create table admin (
id bigint not null auto_increment,
admin_id nvarchar(100) not null,
admin_pwd nvarchar(512) not null,
primary key (id)
);

create table category (
id bigint not null auto_increment,
name nvarchar(100) not null,
primary key (id)
);

create table eproduct (
id bigint not null auto_increment,
name nvarchar(100) not null,
price decimal(15, 5) not null,
date_added datetime not null,
category_id bigint not null,
primary key (id)
);

create table purchases (
id bigint not null auto_increment,
user_id bigint not null,
date datetime not null,
gross_total decimal(15, 5) not null,
primary key (id)
);

create table purchase_items (
id bigint not null auto_increment,
purchase_id bigint not null,
product_id bigint not null,
user_id bigint not null,
rate decimal(15, 5) not null,
quantity int not null,
price decimal(15, 5) not null,
primary key (id)
);

create table users (
id bigint not null auto_increment,
fname nvarchar(100) not null,
lname nvarchar(100) not null,
address nvarchar(100) not null,
age int not null,
date_added datetime not null,
emailid nvarchar(100) not null,
pwd nvarchar(512) not null,
primary key (id)
);
