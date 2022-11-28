insert into admin(admin_id, admin_pwd) values('admin', 'admin');

insert into category (name) values('Athletic shoes');
insert into category (name) values('Ballet flats');
insert into category (name) values('Boat shoes');
insert into category (name) values('Brogue shoes');
insert into category (name) values('Clogs');
insert into category (name) values('Espadrilles');
insert into category (name) values('Flip flops');
insert into category (name) values('High heels');
insert into category (name) values('Loafers');
insert into category (name) values('Oxford shoes');

insert into eproduct (name, price, date_added, category_id) values ('Nike 1', 1000.00, CURRENT_TIMESTAMP, 1);
insert into eproduct (name, price, date_added, category_id) values ('Adidas 1', 1000.00, CURRENT_TIMESTAMP, 1);
insert into eproduct (name, price, date_added, category_id) values ('Reebok 1', 1000.00, CURRENT_TIMESTAMP, 1);
insert into eproduct (name, price, date_added, category_id) values ('Fila 1', 1000.00, CURRENT_TIMESTAMP, 1);

insert into eproduct (name, price, date_added, category_id) values ('Nike 2', 1000.00, CURRENT_TIMESTAMP, 2);
insert into eproduct (name, price, date_added, category_id) values ('Adidas 2', 1000.00, CURRENT_TIMESTAMP, 2);
insert into eproduct (name, price, date_added, category_id) values ('Reebok 2', 1000.00, CURRENT_TIMESTAMP, 2);
insert into eproduct (name, price, date_added, category_id) values ('Fila 2', 1000.00, CURRENT_TIMESTAMP, 2);

insert into eproduct (name, price, date_added, category_id) values ('Nike 3', 1000.00, CURRENT_TIMESTAMP, 3);
insert into eproduct (name, price, date_added, category_id) values ('Adidas 3', 1000.00, CURRENT_TIMESTAMP, 3);
insert into eproduct (name, price, date_added, category_id) values ('Reebok 3', 1000.00, CURRENT_TIMESTAMP, 3);
insert into eproduct (name, price, date_added, category_id) values ('Fila 3', 1000.00, CURRENT_TIMESTAMP, 3);

insert into eproduct (name, price, date_added, category_id) values ('Nike 4', 1000.00, CURRENT_TIMESTAMP, 4);
insert into eproduct (name, price, date_added, category_id) values ('Adidas 4', 1000.00, CURRENT_TIMESTAMP, 4);
insert into eproduct (name, price, date_added, category_id) values ('Reebok 4', 1000.00, CURRENT_TIMESTAMP, 4);
insert into eproduct (name, price, date_added, category_id) values ('Fila 4', 1000.00, CURRENT_TIMESTAMP, 4);

insert into eproduct (name, price, date_added, category_id) values ('Nike 5', 1000.00, CURRENT_TIMESTAMP, 5);
insert into eproduct (name, price, date_added, category_id) values ('Adidas 5', 1000.00, CURRENT_TIMESTAMP, 5);
insert into eproduct (name, price, date_added, category_id) values ('Reebok 5', 1000.00, CURRENT_TIMESTAMP, 5);
insert into eproduct (name, price, date_added, category_id) values ('Fila 5', 1000.00, CURRENT_TIMESTAMP, 5);

insert into eproduct (name, price, date_added, category_id) values ('Nike 6', 1000.00, CURRENT_TIMESTAMP, 6);
insert into eproduct (name, price, date_added, category_id) values ('Adidas 6', 1000.00, CURRENT_TIMESTAMP, 6);
insert into eproduct (name, price, date_added, category_id) values ('Reebok 6', 1000.00, CURRENT_TIMESTAMP, 6);
insert into eproduct (name, price, date_added, category_id) values ('Fila 6', 1000.00, CURRENT_TIMESTAMP, 6);

insert into eproduct (name, price, date_added, category_id) values ('Nike 7', 1000.00, CURRENT_TIMESTAMP, 7);
insert into eproduct (name, price, date_added, category_id) values ('Adidas 7', 1000.00, CURRENT_TIMESTAMP, 7);
insert into eproduct (name, price, date_added, category_id) values ('Reebok 7', 1000.00, CURRENT_TIMESTAMP, 7);
insert into eproduct (name, price, date_added, category_id) values ('Fila 7', 1000.00, CURRENT_TIMESTAMP, 7);

insert into eproduct (name, price, date_added, category_id) values ('Nike 8', 1000.00, CURRENT_TIMESTAMP, 8);
insert into eproduct (name, price, date_added, category_id) values ('Adidas 8', 1000.00, CURRENT_TIMESTAMP, 8);
insert into eproduct (name, price, date_added, category_id) values ('Reebok 8', 1000.00, CURRENT_TIMESTAMP, 8);
insert into eproduct (name, price, date_added, category_id) values ('Fila 8', 1000.00, CURRENT_TIMESTAMP, 8);

insert into eproduct (name, price, date_added, category_id) values ('Nike 9', 1000.00, CURRENT_TIMESTAMP, 9);
insert into eproduct (name, price, date_added, category_id) values ('Adidas 9', 1000.00, CURRENT_TIMESTAMP, 9);
insert into eproduct (name, price, date_added, category_id) values ('Reebok 9', 1000.00, CURRENT_TIMESTAMP, 9);
insert into eproduct (name, price, date_added, category_id) values ('Fila 9', 1000.00, CURRENT_TIMESTAMP, 9);

insert into eproduct (name, price, date_added, category_id) values ('Nike 10', 1000.00, CURRENT_TIMESTAMP, 10);
insert into eproduct (name, price, date_added, category_id) values ('Adidas 10', 1000.00, CURRENT_TIMESTAMP, 10);
insert into eproduct (name, price, date_added, category_id) values ('Reebok 10', 1000.00, CURRENT_TIMESTAMP, 10);
insert into eproduct (name, price, date_added, category_id) values ('Fila 10', 1000.00, CURRENT_TIMESTAMP, 10);

insert into users (fname, lname, address, age, date_added, emailid, pwd) values ('vinodh', 'mahendra', 'india', 40, CURRENT_TIMESTAMP, 'vinodh_mahendra@gmail.com', 'test');
insert into users (fname, lname, address, age, date_added, emailid, pwd) values ('vema', 'venkatesh', 'india', 30, CURRENT_TIMESTAMP, 'vema_venkatesh@gmail.com', 'test');

insert into purchases (user_id, date, gross_total) values (1, CURRENT_TIMESTAMP, 10000.00);
insert into purchases (user_id, date, gross_total) values (2, CURRENT_TIMESTAMP, 10000.00);

insert into purchase_items (purchase_id, product_id, user_id, rate, quantity, price) values (1, 1, 1, 1000, 1, 1000);
insert into purchase_items (purchase_id, product_id, user_id, rate, quantity, price) values (1, 2, 1, 1000, 1, 1000);
insert into purchase_items (purchase_id, product_id, user_id, rate, quantity, price) values (1, 3, 1, 1000, 1, 1000);
insert into purchase_items (purchase_id, product_id, user_id, rate, quantity, price) values (1, 4, 1, 1000, 1, 1000);
insert into purchase_items (purchase_id, product_id, user_id, rate, quantity, price) values (1, 5, 1, 1000, 1, 1000);
insert into purchase_items (purchase_id, product_id, user_id, rate, quantity, price) values (1, 6, 1, 1000, 1, 1000);
insert into purchase_items (purchase_id, product_id, user_id, rate, quantity, price) values (1, 7, 1, 1000, 1, 1000);
insert into purchase_items (purchase_id, product_id, user_id, rate, quantity, price) values (1, 8, 1, 1000, 1, 1000);
insert into purchase_items (purchase_id, product_id, user_id, rate, quantity, price) values (1, 9, 1, 1000, 1, 1000);
insert into purchase_items (purchase_id, product_id, user_id, rate, quantity, price) values (1, 10, 1, 1000, 1, 1000);

insert into purchase_items (purchase_id, product_id, user_id, rate, quantity, price) values (2, 1, 2, 1000, 1, 1000);
insert into purchase_items (purchase_id, product_id, user_id, rate, quantity, price) values (2, 2, 2, 1000, 1, 1000);
insert into purchase_items (purchase_id, product_id, user_id, rate, quantity, price) values (2, 3, 2, 1000, 1, 1000);
insert into purchase_items (purchase_id, product_id, user_id, rate, quantity, price) values (2, 4, 2, 1000, 1, 1000);
insert into purchase_items (purchase_id, product_id, user_id, rate, quantity, price) values (2, 5, 2, 1000, 1, 1000);
insert into purchase_items (purchase_id, product_id, user_id, rate, quantity, price) values (2, 6, 2, 1000, 1, 1000);
insert into purchase_items (purchase_id, product_id, user_id, rate, quantity, price) values (2, 7, 2, 1000, 1, 1000);
insert into purchase_items (purchase_id, product_id, user_id, rate, quantity, price) values (2, 8, 2, 1000, 1, 1000);
insert into purchase_items (purchase_id, product_id, user_id, rate, quantity, price) values (2, 9, 2, 1000, 1, 1000);
insert into purchase_items (purchase_id, product_id, user_id, rate, quantity, price) values (2, 10, 2, 1000, 1, 1000);
