-- Clients
INSERT INTO client VALUES ('DIRTJOE03QZ','Joe','Dirt','1973-08-30','joe@dirt.com','3334445555','12345 Cedar ST SE', 'Buford', 'Alabama', '3300');
INSERT INTO client VALUES ('FRANBEN082R','Benjamin','Franklin','1742-03-06','b@gmail.co','4156409933','12345 Liberty Way', 'Phillidelphia', 'Pennsylvania', '4123');

-- Vehicle Types
INSERT INTO vehicle_type VALUES ('Sedan', 45.00);
INSERT INTO vehicle_type VALUES ('Van', 60.00);
INSERT INTO vehicle_type VALUES ('Luxury', 300.00);

-- Insurance
INSERT INTO insurance VALUES ('STFRM-008838475', 'Good', 20000.00, 10000.00, 8000.00, 80.00);

-- Branches
INSERT INTO branch VALUES (1, '4255555555', '07:00:00', '17:00:00', '09:00:00', '18:00:00', TRUE, '123 Street', 'Everett', 'Washington', '98201');
INSERT INTO branch VALUES (2, '4253336666', '07:00:00', '17:00:00', '09:00:00', '18:00:00', FALSE, '10882 Colby Ave', 'Everett', 'Washington', '98201');
INSERT INTO branch VALUES (3, '4257790352', '05:00:00', '19:00:00', '05:00:00', '19:00:00', FALSE, '42 3rd Ave', 'Everett', 'Washington', '98201');

-- Vehicles
INSERT INTO vehicle VALUES ('AWS-633', 'Toyota', 'Corolla', 'BlueGreen', 'Sedan', 5, 32000, 'STFRM-008838475', 2, TRUE);
INSERT INTO vehicle VALUES ('QRNTUVY', 'Toyota', 'Corolla', 'White', 'Sedan', 5, 200000, 'STFRM-008838475', 2, TRUE);
INSERT INTO vehicle VALUES ('ACNO899', 'Ford', 'Focus', 'Red', 'Sedan', 5, 60345, 'STFRM-008838475', 3, TRUE);
INSERT INTO vehicle VALUES ('TWITTER', 'Tesla', 'Roadster', 'Silver', 'Luxury', 2, 12000, 'STFRM-008838475', 1, TRUE);

-- Bookings
INSERT INTO booking (vehicle_license, client_license_number, start_odometer, start_tank, cost, payment_type, pickup_branch_id, pickup_date, dropoff_branch_id, dropoff_date) 
VALUES ('AWS-633', 'DIRTJOE03QZ', 40000, 3.4, 45.00, 'CASH', (SELECT current_branch FROM vehicle WHERE license = 'AWS-633'), '2018-11-17', 3, '2018-11-18');

INSERT INTO booking (vehicle_license, client_license_number, start_odometer, start_tank, cost, payment_type, pickup_branch_id, pickup_date, dropoff_branch_id, dropoff_date) 
VALUES ('ACNO899', 'DIRTJOE03QZ', 40200, 6.0, 90.00, 'CASH', (SELECT current_branch FROM vehicle WHERE license = 'ACNO899'), '2018-11-28', 2, '2018-11-30');