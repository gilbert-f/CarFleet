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
)