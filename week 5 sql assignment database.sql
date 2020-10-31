CREATE DATABASE if not exists sports;
USE sports;
DROP TABLE if exists sports;
CREATE TABLE sports(
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(40) NOT NULL,
PRIMARY KEY(id)
);

