CREATE TABLE vehicle_type
(
	name VARCHAR(50),
	rate DECIMAL(8,2) NOT NULL,
	CONSTRAINT pk__vehicle_type PRIMARY KEY (name)
)