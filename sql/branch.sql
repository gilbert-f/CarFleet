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
)