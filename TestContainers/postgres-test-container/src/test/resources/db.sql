CREATE TABLE users (
    id INTEGER NOT NULL,
    name VARCHAR (255) NOT NULL,
    birth DATE NOT NULL,
    CONSTRAINT pk PRIMARY KEY (ID)
);

INSERT INTO
Users (id, name, birth)
VALUES
(1, 'User 1', '1980-02-23'),
(2, 'User 2', '1981-03-24'),
(3, 'User 3', '1982-04-25'),
(4, 'User 4', '1983-05-26');
