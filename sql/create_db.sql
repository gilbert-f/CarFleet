-- Compilation of individual table SQL files
-- Creates all tables in the correct order

DROP TABLE booking;
DROP TABLE vehicle;
DROP TABLE client;
DROP TABLE branch;
DROP TABLE vehicle_type;
DROP TABLE insurance;

CREATE TABLE client
(
    license_number VARCHAR(50),
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    dob DATE NOT NULL,
    email VARCHAR(50) NOT NULL,
    phone VARCHAR(32) NOT NULL,
    street VARCHAR(50) NOT NULL,
    city VARCHAR(50) NOT NULL,
    state VARCHAR(50) NOT NULL,
    zip VARCHAR(50) NOT NULL,
    CONSTRAINT pk__client PRIMARY KEY (license_number)
);

CREATE TABLE vehicle_type
(
	name VARCHAR(50),
	rate DECIMAL(8,2) NOT NULL,
	CONSTRAINT pk__vehicle_type PRIMARY KEY (name)
);

CREATE TABLE insurance
(
    id VARCHAR(50),
    type VARCHAR(50) NOT NULL,
    body DECIMAL(8,2) NOT NULL,
    collision DECIMAL(8,2) NOT NULL,
    medical DECIMAL(8,2) NOT NULL,
    rate DECIMAL(8,2) NOT NULL,
    CONSTRAINT pk__insurance PRIMARY KEY (id)
);

CREATE TABLE branch
(
	id INTEGER AUTO_INCREMENT,
	phone VARCHAR(32) NOT NULL,
	open_time TIME NOT NULL,
	close_time TIME NOT NULL,
	wkend_open_time TIME NOT NULL,
	wkend_close_time TIME NOT NULL,
	after_hour_drop_off BOOL NOT NULL DEFAULT FALSE,
	street VARCHAR(50) NOT NULL,
	city VARCHAR(50) NOT NULL,
	state VARCHAR(50) NOT NULL,
	zip VARCHAR(50) NOT NULL,
	CONSTRAINT pk__branch PRIMARY KEY (id),
	CONSTRAINT ck__branch__hours CHECK (open_time < close_time),
	CONSTRAINT ck__branch__wk_hours CHECK (wkend_open_time < wkend_close_time)
);

CREATE TABLE vehicle
(
    license CHAR(7),
    make VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    color VARCHAR(20) NOT NULL,
    type_name VARCHAR(50) NOT NULL,
    seats INTEGER NOT NULL,
    odometer INTEGER DEFAULT 0,
    insurance_id VARCHAR(50) NOT NULL,
    current_branch INTEGER NOT NULL,
    availability BOOLEAN,
    CONSTRAINT pk__vehicle PRIMARY KEY (license),
    CONSTRAINT fk__vehicle_type__vehicle FOREIGN KEY (type_name) REFERENCES vehicle_type (name),
    CONSTRAINT fk__insurance__vehicle FOREIGN KEY (insurance_id)  REFERENCES insurance (id),
    CONSTRAINT fk__branch__vehicle FOREIGN KEY (current_branch) REFERENCES branch (id),
    CONSTRAINT ck__vehicle__license__charset CHECK (license NOT RLIKE '[^A-Z0-9\ \-]')
);

CREATE TABLE booking
(
    id INTEGER AUTO_INCREMENT,
    vehicle_license VARCHAR(7) NOT NULL,
    client_license_number VARCHAR(50) NOT NULL,
    start_odometer INTEGER,
    end_odometer INTEGER,
    start_tank DECIMAL(4,2),
    end_tank DECIMAL(4,2),
    cost DECIMAL(8,2) NOT NULL DEFAULT 0.00,
    payment_type VARCHAR(50) NOT NULL,
    pickup_branch_id INTEGER,
    pickup_date DATETIME,
    dropoff_branch_id INTEGER,
    dropoff_date DATETIME,
    CONSTRAINT pk__booking PRIMARY KEY (id), 
    CONSTRAINT fk__vehicle__booking FOREIGN KEY (vehicle_license) REFERENCES vehicle (license),
    CONSTRAINT fk__client__booking FOREIGN KEY (client_license_number) REFERENCES client (license_number),
    CONSTRAINT ck__booking__odometer CHECK (start_odometer <= end_odometer),
    CONSTRAINT ck__booking__dates CHECK (pickup_date <= dropoff_date)
);

DELIMITER //

CREATE TRIGGER tr__booking__double_booking
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
END; //

DELIMITER ;