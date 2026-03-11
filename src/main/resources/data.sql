
INSERT INTO products (title, description, price, stock, thumbnail) VALUES
('iPhone 9', 'An apple mobile which is nothing like apple', 549.00, 94, 'https://cdn.dummyjson.com/product-images/1/thumbnail.jpg'),
('iPhone X', 'SIM-Free, Model A19211 6.5-inch Super Retina HD display with OLED technology A12 Bionic chip', 899.00, 34, 'https://cdn.dummyjson.com/product-images/2/thumbnail.jpg'),
('Samsung Universe 9', 'Samsung''s new variant which goes beyond Galaxy to the Universe', 1249.00, 36, 'https://cdn.dummyjson.com/product-images/3/thumbnail.jpg'),
('OPPOF19', 'OPPO F19 is officially announced on April 2021.', 280.00, 123, 'https://cdn.dummyjson.com/product-images/4/thumbnail.jpg'),
('Huawei P30', 'Huawei’s re-badged P30 Pro New Edition was officially unveiled yesterday in Germany', 499.00, 32, 'https://cdn.dummyjson.com/product-images/5/thumbnail.jpg'),
('MacBook Pro', 'MacBook Pro 2021 with mini-LED display may launch between September, November', 1749.00, 83, 'https://cdn.dummyjson.com/product-images/6/thumbnail.jpg'),
('Samsung Galaxy Book', 'Samsung Galaxy Book S (2020) Laptop with Intel Lakefield chip, 8GB of RAM', 1499.00, 50, 'https://cdn.dummyjson.com/product-images/7/thumbnail.jpg'),
('Microsoft Surface Laptop 4', 'Style and speed. Stand out on HD video calls backed by Studio Mics. Capture ideas on the vibrant touchscreen.', 1499.00, 68, 'https://cdn.dummyjson.com/product-images/8/thumbnail.jpg'),
('Infinix INBOOK', 'Infinix Inbook X1 Ci3 10th 8GB 256GB 14 Win10 Grey – 1 Year Warranty', 1099.00, 96, 'https://cdn.dummyjson.com/product-images/9/thumbnail.jpg'),
('HP Pavilion 15', 'HP Pavilion 15-DK1056WM Gaming Laptop 10th Gen Core i5, 8GB, 256GB SSD, GTX 1650 4GB', 1099.00, 89, 'https://cdn.dummyjson.com/product-images/10/thumbnail.jpg'),
('Perfume Oil', 'Mega Discount, Impression of Acqua Di Gio by GiorgioArmani concentrated attar perfume Oil', 13.00, 65, 'https://cdn.dummyjson.com/product-images/11/thumbnail.jpg'),
('Brown Perfume', 'Royal_Mirage Sport Brown Perfume for Men & Women - 120ml', 40.00, 52, 'https://cdn.dummyjson.com/product-images/12/thumbnail.jpg');


INSERT INTO cart (user_id) VALUES (1);

INSERT INTO cart_item (cart_id, products_id, quantity) VALUES (1, 1, 2.0);

INSERT INTO cart_item (cart_id, products_id, quantity) VALUES (1, 3, 1.0);


INSERT INTO cart (user_id) VALUES (2);

INSERT INTO cart_item (cart_id, products_id, quantity) VALUES (2, 3, 2.0);

INSERT INTO cart_item (cart_id, products_id, quantity) VALUES (2, 4, 1.0);
