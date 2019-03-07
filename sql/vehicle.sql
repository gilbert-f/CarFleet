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
)