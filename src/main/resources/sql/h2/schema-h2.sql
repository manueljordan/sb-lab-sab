CREATE TABLE persona(
	id 	   VARCHAR(3) NOT NULL,
	nombre VARCHAR(20) NOT NULL,
	apellido VARCHAR(20) NOT NULL,
	documento VARCHAR(20) NOT NULL,
	edad TINYINT NOT NULL,
	profesion VARCHAR(50) NOT NULL,
	PRIMARY KEY (id)
);