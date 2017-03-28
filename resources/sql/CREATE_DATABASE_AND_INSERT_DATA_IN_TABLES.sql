DROP database IF EXISTS car_shop;
CREATE database if not exists car_shop default CHARACTER set utf8 ;
use car_shop;

DROP TABLE IF exists USERS;
CREATE TABLE If not exists USERS(
id int not null AUTO_INCREMENT, 
first_name varchar(45) not null,
last_name varchar(45) not null,
email varchar(255) not null,
password varchar (32) not null,
login varchar(40) not null,
banTime timestamp null default null,
amountOfWrongLoginAttemps int default 0,
primary key (id),
unique index id_unique (id asc),
unique index login_unique (login asc));

INSERT INTO USERS (first_name,last_name,email,password,login) values("Valerii","Osmachko","v_osmachko@mail.ru","Asdet346yreg","valeron1994");
INSERT INTO USERS (first_name,last_name,email,password,login) values("Vladislav","Zahorodnii","vladik@gmail.com","Qwerdfssdb4563","vlad1996");
INSERT INTO USERS (first_name,last_name,email,password,login) values("Serheii","Shapoval","shapoval@gmail.com","Qwervggdeyrdfvgf","serSap228");

use car_shop;
select * from USERS;

DROP TABLE IF exists CATEGORY;
CREATE TABLE IF not exists CATEGORY(
idCategory int not null auto_increment,
category varchar(50) not null,
primary key (idCategory));

DROP TABLE IF exists MANUFACTURER;
CREATE TABLE IF not exists MANUFACTURER(
idManufacturer int not null auto_increment,
manufacturer varchar(50) not null,
primary key (idManufacturer));


DROP TABLE IF exists PRODUCTS;
CREATE TABLE IF not exists PRODUCTS(
idProduct int not null auto_increment,
Name varchar(40) not null,
price double not null,
Category_idCategory int not null,
Manufacturer_idManufacturer int not null,
description varchar(200),
primary key (idProduct),
foreign key (Category_idCategory) references CATEGORY(idCategory),
foreign key (Manufacturer_idManufacturer) references MANUFACTURER(idManufacturer)
);


INSERT INTO CATEGORY (category) value('Jeep');
INSERT INTO CATEGORY (category) value('Passenger Car');
INSERT INTO CATEGORY (category) value('Truck');

INSERT INTO MANUFACTURER (manufacturer) value('Germany');
INSERT INTO MANUFACTURER (manufacturer) value('USA');
INSERT INTO MANUFACTURER (manufacturer) value('United Kindom');

INSERT INTO PRODUCTS (Name,price,Category_idCategory,Manufacturer_idManufacturer,description) values('Audi',5000,1,1,'Amazing audi');
INSERT INTO PRODUCTS (Name,price,Category_idCategory,Manufacturer_idManufacturer,description) values('Dodge',6000,2,2,'Amazing Dodge');
INSERT INTO PRODUCTS (Name,price,Category_idCategory,Manufacturer_idManufacturer,description) values('Jaguar',3000,3,3,'Amazing Jaguar');
INSERT INTO PRODUCTS (Name,price,Category_idCategory,Manufacturer_idManufacturer,description) values('BMW',5000,3,3,'Amazing BMW');
INSERT INTO PRODUCTS (Name,price,Category_idCategory,Manufacturer_idManufacturer,description) values('Dodge',2435,2,2,'Amazing Dodge asd');
INSERT INTO PRODUCTS (Name,price,Category_idCategory,Manufacturer_idManufacturer,description) values('LADA',235231,3,1,'Amazing Jaguar gggg');
INSERT INTO PRODUCTS (Name,price,Category_idCategory,Manufacturer_idManufacturer,description) values('Mercedec',5523,2,1,'Amazing BMW');
INSERT INTO PRODUCTS (Name,price,Category_idCategory,Manufacturer_idManufacturer,description) values('Toyota',32123,1,3,'Amazing TOyota asd');
INSERT INTO PRODUCTS (Name,price,Category_idCategory,Manufacturer_idManufacturer,description) values('VAZ',1234,3,2,'Amazing VAZ');


      



         
DROP TABLE IF exists ORDERS;
CREATE TABLE IF not exists ORDERS(
idOrder varchar(50),
Status ENUM('ACCEPTED','CONFIRMED','FORMED','EXPELLED','COMPLETED','CANCELED') not null,
Date timestamp not null,
User_idUser int not null,
Details varchar(200),
uuid varchar(50) not null,
address varchar(200) not null,
cardNumber varchar(50) not null,
primary key (idOrder),
foreign key (User_idUser) references USERS(id)
);         

DROP TABLE IF exists CART_INFO;
CREATE TABLE IF not exists CART_INFO(
idCart int not null auto_increment,
idOrderCart varchar(50),
Product_idProduct int not null,
amount int not null,
priceForOne double not null,
primary key(idCart),
foreign key(Product_idProduct) references PRODUCTS(idProduct),
foreign key(idOrderCart) references ORDERS(idOrder)
);   


SELECT * FROM USERS;
UPDATE USERS SET amountOfWrongLoginAttemps = 0 WHERE login='toxa99';

/*SELECT * FROM PRODUCTS WHERE Category_idCategory LIKE '%2%'  OR Category_idCategory LIKE '%1%'  AND price BETWEEN  10  AND  1000  AND  Manufacturer_idManufacturer LIKE ?  OR Manufacturer_idManufacturer LIKE ?  AND Name LIKE ?  OR Name LIKE ?  OR Name LIKE ?  ORDER BY Name ASC;
/*SELECT * FROM PRODUCTS where Name = ?;
SELECT * FROM PRODUCTS where ProductCategoty = ?;
SELECT * FROM PRODUCTS where manufacturer = ?;
SELECT * FROM PRODUCTS where price BETWEEN ? AND ?;