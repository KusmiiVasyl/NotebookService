INSERT INTO address (city, street, longitude, latitude) VALUES
('Lviv', 'Ivana Franka', 24.0333447, 49.8317282),
('Kyiv', 'Nezalegnosti', 30.453466912009034, 50.47119865),
('Ternopil', 'Obolonia', 49.542409, 25.592429),
('Ughorod', 'Syrikova', 48.605945, 22.291196),
('Struy', 'Morozenka', 49.264914, 23.836445),
('Radehiv', 'Soniachna', 50.275352, 24.638054);

INSERT INTO cargo (name, amount) VALUES
('Bananas', 3500.560),
('Oranges', 6800.987),
('Potato', 9800.120),
('Onion', 4895.302),
('Beet', 6988.950),
('Meat', 10300.569),
('Cheese', 7800.450),
('Avocado', 2300.500);

INSERT INTO transporter (name, car_model, load_capacity) VALUES
('VELANT TRANS UKRAINE, LLC', 'Mercedes-Benz L 319 D', 10000),
('AUTO-LOGIST, LLC', 'Ford Transit', 10000),
('BINGO-TOUR, LLC', 'Volkswagen Transporter T1b', 8000),
('MURRAY, LLC', 'Goliath GD 750', 15000),
('MUSTANG-AVTOTRANS, LLC', 'Mitsubishi Fuso Canter', 15000),
('HINKSTON, LLC', 'Chevrolet 9100 LCF Moving Pup Trailer', 12000),
('ARTVEY PLUS, LLC', 'Ford Serie C Pup Trailer', 18000),
('VIDO, LLC', 'Dodge LCF CT 900 Belly Dump Trailer', 18000),
('ZLATATRANS, LLC', 'Western Star 4864 Tipper', 18000);

INSERT INTO warehouse (title, address_id) VALUES
('Storage №1', 1),
('Storage №2', 1),
('Storage №3', 1),
('Storage №4', 2),
('Storage №5', 2),
('Storage №6', 3),
('Storage №7', 4),
('Storage №8', 5),
('Storage №9', 6),
('Storage №10', 6);

INSERT INTO delivery (warehouse_from_id, warehouse_to_id, transporter_id, cargo_id, status_of_delivery) VALUES
(1, 5, 3, 8, 1),
(5, 6, 2, 6, 3),
(3, 1, 1, 4, 5),
(2, 4, 6, 7, 2),
(10, 3, 9, 2, 7),
(9, 6, 4, 1, 6),
(7, 8, 8, 3, 5),
(8, 2, 7, 8, 1),
(4, 10, 6, 4, 3),
(2, 5, 2, 3, 2);


