DROP DATABASE IF EXISTS beautysalon;

CREATE DATABASE beautysalon;

USE beautysalon;

CREATE TABLE  role
(
    id BIGINT(20) NOT NULL AUTO_INCREMENT,
    role_name ENUM ('USER', 'MASTER', 'ADMIN'),
    PRIMARY KEY (id)
);

INSERT INTO role (id, role_name)
VALUES (DEFAULT, 'USER'),
       (DEFAULT, 'MASTER'),
       (DEFAULT, 'ADMIN');

CREATE TABLE user
(
        id BIGINT(20) NOT NULL AUTO_INCREMENT,
        name VARCHAR(50) NOT NULL,
        email VARCHAR(50) NOT NULL UNIQUE,
        password VARCHAR(50) NOT NULL,
        role_id BIGINT(20) NOT NULL,
        created DATETIME DEFAULT CURRENT_TIMESTAMP,
        PRIMARY KEY (id),
        FOREIGN KEY (role_id) REFERENCES role(id)
);

INSERT INTO user (id, name, email, password, role_id, created)
VALUES (DEFAULT, 'Irina Alymova', 'i.o.alymova@gmail.com', 'qwerty', 3, DEFAULT),
       (DEFAULT, 'Dmytro Halushchak', 'dmitry.galuschak@gmail.com', 'qwerty', 1, DEFAULT),
       (DEFAULT, 'Dmitriy Galushchak', 'leadhunter.tech@gmail.com', 'qwerty', 1, DEFAULT),
       (DEFAULT, 'Camilla Bridge', 'camilla.bridge@gmail.com', 'qwerty', 2, DEFAULT),
       (DEFAULT, 'Lolly Finch', 'lolly.finch@gmail.com', 'qwerty', 2, DEFAULT),
       (DEFAULT, 'Samantha Jones', 'smantha.jones@gmail.com', 'qwerty', 2, DEFAULT);