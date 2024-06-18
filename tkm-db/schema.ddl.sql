DROP TABLE IF EXISTS likes; 
DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS activities;

CREATE TABLE roles (
	id serial,
	code_role VARCHAR(50) UNIQUE NOT NULL,
	role_name VARCHAR(50) UNIQUE NOT NULL,
	CONSTRAINT pk_role_id PRIMARY KEY(id)
);
	
CREATE TABLE accounts (
	id serial,
	first_name VARCHAR(250) NOT NULL,
	last_name VARCHAR(250) NOT NULL,
	email VARCHAR(255) UNIQUE NOT NULL,
	password VARCHAR(255) NOT NULL,
	role_id INTEGER NOT NULL,
	CONSTRAINT pk_account_id PRIMARY KEY(id),
	CONSTRAINT fk_role_id 
		FOREIGN KEY(role_id) REFERENCES roles(id)
);

CREATE TABLE activities (
	id serial,
	name VARCHAR(200) UNIQUE NOT NULL,
	description VARCHAR(1000) NOT NULL,
	image_url VARCHAR(300) UNIQUE NOT NULL,
	location VARCHAR(200) NOT NULL,
    link_url VARCHAR(300) NOT NULL,
    created_at DATE NOT NULL,
    CONSTRAINT pk_activity_id PRIMARY KEY(id)
);

CREATE TABLE likes (
	id serial,
	activity_id INT NOT NULL,
	account_id INT NOT NULL,
	UNIQUE (activity_id, account_id),
	CONSTRAINT pk_like_id PRIMARY KEY(id),
	CONSTRAINT fk_activity_id 
		FOREIGN KEY(activity_id) REFERENCES activities(id),
	CONSTRAINT fk_account_id 
		FOREIGN KEY(account_id) REFERENCES accounts(id)
);