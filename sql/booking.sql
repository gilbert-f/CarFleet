-- CREATE TABLE booking
-- (
--    id INTEGER AUTO_INCREMENT,
--    vehicle_license VARCHAR(7) NOT NULL,
--    client_license_number VARCHAR(50) NOT NULL,
--    start_odometer INTEGER,
--    end_odometer INTEGER,
--    start_tank DECIMAL(4,2),
--    end_tank DECIMAL(4,2),
--    cost DECIMAL(8,2) NOT NULL DEFAULT 0.00,
--    payment_type VARCHAR(50) NOT NULL,
--    pickup_branch_id INTEGER,
--    pickup_date DATETIME,
--    dropoff_branch_id INTEGER,
--    dropoff_date DATETIME,
--    CONSTRAINT pk__booking PRIMARY KEY (id), 
--    CONSTRAINT fk__vehicle__booking FOREIGN KEY (vehicle_license) REFERENCES vehicle (license),
--    CONSTRAINT fk__client__booking FOREIGN KEY (client_license_number) REFERENCES client (license_number),
--    CONSTRAINT fk__branch__booking_pickup FOREIGN KEY (pickup_branch_id) REFERENCES branch (id),
--    CONSTRAINT fk__branch__booking_dropoff FOREIGN KEY (dropoff_branch_id) REFERENCES branch (id),
--    CONSTRAINT ck__booking__odometer CHECK (start_odometer <= end_odometer),
--    CONSTRAINT ck__booking__dates CHECK (pickup_date <= dropoff_date)
-- );

DELIMITER //

CREATE TRIGGER tr__booking__double_booking__insert
	BEFORE INSERT ON booking
	FOR EACH ROW
BEGIN
	IF EXISTS
	(
		SELECT * FROM booking
		WHERE vehicle_license = NEW.vehicle_license AND
		(
			NEW.pickup_date BETWEEN pickup_date AND dropoff_date
			OR NEW.dropoff_date BETWEEN pickup_date AND dropoff_date
			OR (NEW.pickup_date < pickup_date AND NEW.dropoff_date > dropoff_date)
		)
		LIMIT 1
	)
	THEN 
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Attempt to double book vehicle.';
	END IF;
END;//

DELIMITER ;

DELIMITER //

CREATE TRIGGER tr__booking__double_booking__update
	BEFORE UPDATE ON booking
	FOR EACH ROW
BEGIN
	IF EXISTS
	(
		SELECT * FROM booking
		WHERE vehicle_license = NEW.vehicle_license AND
		(
			NEW.pickup_date BETWEEN pickup_date AND dropoff_date
			OR NEW.dropoff_date BETWEEN pickup_date AND dropoff_date
			OR (NEW.pickup_date < pickup_date AND NEW.dropoff_date > dropoff_date)
		)
		LIMIT 1
	)
	THEN 
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Attempt to double book vehicle.';
	END IF;
END;//

DELIMITER ;
