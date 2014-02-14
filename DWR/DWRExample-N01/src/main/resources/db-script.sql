DROP DATABASE IF EXISTS realmedia;
CREATE DATABASE realmedia;
USE realmedia;

CREATE TABLE regions (region_id BIGINT AUTO_INCREMENT PRIMARY KEY, region_name VARCHAR(255));

INSERT INTO regions (region_name) VALUES ("Region 1"), ("Region 2"), ("Region 3"), ("Region 4");