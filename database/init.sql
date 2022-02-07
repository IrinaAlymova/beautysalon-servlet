DROP DATABASE IF EXISTS beautysalon;

CREATE DATABASE beautysalon;

USE beautysalon;

CREATE TABLE  role
(
    id BIGINT(20) NOT NULL AUTO_INCREMENT,
    name ENUM ('USER', 'MASTER', 'ADMIN'),
    PRIMARY KEY (id)
);

INSERT INTO role (id, name)
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
        created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        PRIMARY KEY (id),
        FOREIGN KEY (role_id) REFERENCES role(id)
);

INSERT INTO user (id, name, email, password, role_id, created)
VALUES (DEFAULT, 'Irina Alymova', 'i.o.alymova@gmail.com', 'd8578edf8458ce06fbc5bb76a58c5ca4', 3, DEFAULT),
       (DEFAULT, 'Brigitte Fine', 'bridgite.fine@mymail.com', 'd8578edf8458ce06fbc5bb76a58c5ca4', 1, DEFAULT),
       (DEFAULT, 'Cynthia Kim', 'cynthia.kim@mymail.com', 'd8578edf8458ce06fbc5bb76a58c5ca4', 1, DEFAULT),
       (DEFAULT, 'Camilla Bridge', 'camilla.bridge@mymail.com', 'd8578edf8458ce06fbc5bb76a58c5ca4', 2, DEFAULT),
       (DEFAULT, 'Margaret Simpson', 'margaret.simpson@mymail.com', 'd8578edf8458ce06fbc5bb76a58c5ca4', 2, DEFAULT),
       (DEFAULT, 'Lolly Finch', 'lolly.finch@mymail.com', 'd8578edf8458ce06fbc5bb76a58c5ca4', 2, DEFAULT),
       (DEFAULT, 'Maria Way', 'maria.way@mymail.com', 'd8578edf8458ce06fbc5bb76a58c5ca4', 2, DEFAULT),
       (DEFAULT, 'Sansa Stark', 'sansa.stark@mymail.com', 'd8578edf8458ce06fbc5bb76a58c5ca4', 2, DEFAULT),
       (DEFAULT, 'Katherine Cobbe', 'katherine.cobb@mymail.com', 'd8578edf8458ce06fbc5bb76a58c5ca4', 2, DEFAULT),
       (DEFAULT, 'Samantha Jones', 'smantha.jones@mymail.com', 'd8578edf8458ce06fbc5bb76a58c5ca4', 2, DEFAULT);

CREATE TABLE service
(
    id BIGINT(20) NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    price INT NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO service (id, name, price)
VALUES (DEFAULT, 'Haircut', 300),
       (DEFAULT, 'Manicure', 200),
       (DEFAULT, 'Solarium', 150),
       (DEFAULT, 'Makeup', 350),
       (DEFAULT, 'Massage', 500);

CREATE TABLE master
(
    id BIGINT(20) NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    service_id BIGINT(20) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (service_id) REFERENCES service(id)
);

INSERT INTO master (id, name, service_id)
VALUES (DEFAULT, 'Camilla Bridge', 1),
       (DEFAULT, 'Margaret Simpson', 1),
       (DEFAULT, 'Lolly Finch', 2),
       (DEFAULT, 'Samantha Jones', 3),
       (DEFAULT, 'Maria Way', 4),
       (DEFAULT, 'Sansa Stark', 4),
       (DEFAULT, 'Katherine Cobbe', 5);

CREATE TABLE booking
(
    id BIGINT(20) NOT NULL AUTO_INCREMENT,
    user_id BIGINT(20) NOT NULL,
    master_id BIGINT(20) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (master_id) REFERENCES master(id)
);

INSERT INTO booking (id, user_id, master_id)
VALUES (DEFAULT, 1, 2),
       (DEFAULT, 2, 4),
       (DEFAULT, 3, 5),
       (DEFAULT, 4, 7),
       (DEFAULT, 5, 7);