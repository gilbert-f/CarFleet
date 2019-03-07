-- Try to insert a branch w/ an open time that is after close time
INSERT INTO branch (phone, open_time, close_time, wkend_open_time, wkend_close_time, after_hour_drop_off, street, city, state, zip)
	VALUES ('4255555555', '14:00:00', '10:00:00', '09:00:00', '18:00:00', TRUE, '123 Street', 'Everett', 'Washington', '98201');

-- Try to insert a branch w/ a weekend open time that is after weekend close
INSERT INTO branch (phone, open_time, close_time, wkend_open_time, wkend_close_time, after_hour_drop_off, street, city, state, zip)
	VALUES ('4255555555', '07:00:00', '17:00:00', '12:30:00', '12:00:00', TRUE, '123 Street', 'Everett', 'Washington', '98201');
	
-- Try to insert a non alphanumeric or '-', ' ' value into license
INSERT INTO vehicle VALUES ('ACN.899', 'Ford', 'Focus', 'Red', 'Sedan', 5, 60345, 'STFRM-008838475', 3, TRUE);

-- Try to insert a starting odometer value that is greater than the ending odometer value
INSERT INTO booking (vehicle_license, client_license_number, start_odometer, end_odometer, payment_type, pickup_branch_id, pickup_date, dropoff_branch_id, dropoff_date) 
VALUES ('AWS-633', 'DIRTJOE03QZ', 40000, 38000, 'CASH', 2, '2018-11-17', 3, '2018-11-18');

-- Try to insert a pickup date that is after the dropoff date
INSERT INTO booking (vehicle_license, client_license_number, start_odometer, end_odometer, payment_type, pickup_branch_id, pickup_date, dropoff_branch_id, dropoff_date) 
VALUES ('AWS-633', 'DIRTJOE03QZ', 40000, 40030,'CASH', 2, '2018-11-18', 3, '2018-11-16');