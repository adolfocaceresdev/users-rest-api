CREATE DATABASE usersdb;


DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    firstname VARCHAR(100) NOT NULL,
    lastname VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

INSERT INTO users (firstname, lastname, email, password) VALUES
('Camila', 'Vargas', 'camila.vargas@example.com', 'camiPass01'),
('Diego', 'Castro', 'diego.castro@example.com', 'diegoSecure!'),
('Adriana', 'Mendoza', 'adriana.mendoza@example.com', 'adri1234'),
('Felipe', 'Suárez', 'felipe.suarez@example.com', 'felipePass99'),
('Sofía', 'Herrera', 'sofia.herrera@example.com', 'sofiSecure22'),
('Renato', 'Silva', 'renato.silva@example.com', 'renatoPass2024');