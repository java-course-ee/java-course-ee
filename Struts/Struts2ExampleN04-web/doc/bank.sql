INSERT INTO bank.person (first_name, last_name, birth_date)
VALUES ('Ivan', 'Ivanov', '1985-01-01');
INSERT INTO bank.person (first_name, last_name, birth_date)
VALUES ('Petr', 'Petrov', '1980-02-03');
INSERT INTO bank.person (first_name, last_name, birth_date)
VALUES ('Sidor', 'Sidorov', '1993-04-12');

INSERT INTO bank.account ( OWNER ) VALUES (1);
INSERT INTO bank.account ( OWNER ) VALUES (1);
INSERT INTO bank.account ( OWNER ) VALUES (1);
INSERT INTO bank.account ( OWNER ) VALUES (2);
INSERT INTO bank.account ( OWNER ) VALUES (2);
INSERT INTO bank.account ( OWNER ) VALUES (3);

INSERT INTO bank.transfer (senders_account, recievers_account, amount,  COMMENT )
VALUES (1, 4, 100, 'Долг за пиво');
INSERT INTO bank.transfer (senders_account, recievers_account, amount,  COMMENT )
VALUES (6, 3, 29000.01, 'Оплата квартиры за вычетом коммунальных платежей');