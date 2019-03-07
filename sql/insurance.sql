CREATE TABLE insurance
(
    id VARCHAR(50),
    type VARCHAR(50) NOT NULL,
    body DECIMAL(8,2) NOT NULL,
    collision DECIMAL(8,2) NOT NULL,
    medical DECIMAL(8,2) NOT NULL,
    rate DECIMAL(8,2) NOT NULL,
    CONSTRAINT pk__insurance PRIMARY KEY (id)
)