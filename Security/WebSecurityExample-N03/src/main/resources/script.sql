create database securityrealm;

use securityrealm;

create table users (
  user_name         varchar(15) not null primary key,
  user_pass         varchar(15) not null
);

create table user_roles (
  user_name         varchar(15) not null,
  role_name         varchar(15) not null,
  primary key(user_name, role_name)
);

INSERT INTO users (user_name, user_pass) VALUES ('admin', 'admin');
INSERT INTO users (user_name, user_pass) VALUES ('user', 'user');


INSERT INTO user_roles (user_name, role_name) VALUES ('admin' 'user');
INSERT INTO user_roles (user_name, role_name) VALUES ('admin', 'administrator');
INSERT INTO user_roles (user_name, role_name) VALUES ('user', 'user');