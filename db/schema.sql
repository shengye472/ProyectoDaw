
DROP DATABASE IF EXISTS shop;

CREATE DATABASE shop;

USE shop;

CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    bar_code VARCHAR(20) UNIQUE NOT NULL, 
    name VARCHAR(25) NOT NULL,
    price_sell DECIMAL(10, 2) NOT NULL,
    price_buy DECIMAL(10, 5) NOT NULL,
    stock INT
)

CREATE TABLE sales (
    id INT AUTO_INCREMENT PRIMARY KEY,
    date DATETIME NOT NULL,
    total DECIMAL(10, 2) NOT NULL
)

CREATE TABLE detail_sale (
    id INT AUTO_INCREMENT PRIMARY KEY,
    quantity INT NOT NULL,
    subtotal DECIMAL(10, 2) NOT NULL,
    id_sale INT NOT NULL,
    Foreign Key (id_sale) REFERENCES sales(id),
    id_product INT NOT NULL,
    Foreign Key (id_product) REFERENCES products(id)   
)