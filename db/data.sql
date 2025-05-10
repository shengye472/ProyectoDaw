
USE shop;

INSERT INTO products (bar_code, name, price_sell, price_buy, stock) VALUES 
('1234567890', 'Product 1', 10.00, 5.00, 10),
('0987654321', 'Product 2', 20.00, 10.00, 5),
('1357924680', 'Product 3', 30.00, 15.00, 6),
('2468013579', 'Product 4', 40.00, 20.00, 7),
('9876543210', 'Product 5', 50.00, 25.00, 8);

INSERT INTO sales (date, total) VALUES 
('2022-12-31 23:59:59', 100.00),
('2023-01-01 00:00:00', 200.00),
('2023-01-01 00:00:01', 300.00),
('2023-01-01 00:00:02', 400.00),
('2023-01-01 00:00:03', 500.00);

INSERT INTO detail_sale (quantity, subtotal, id_sale, id_product) VALUES 
(1, 10.00, 1, 1),
(2, 40.00, 2, 2),
(3, 90.00, 3, 3),
(4, 160.00, 4, 4),
(5, 250.00, 5, 5);

INSERT INTO users (username, password, rol) VALUES 
('user', 'user', 1)