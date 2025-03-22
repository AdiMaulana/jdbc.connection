CREATE DATABASE android_db;
USE android_db;

CREATE TABLE android_version (
    id INT PRIMARY KEY AUTO_INCREMENT,
    version_name VARCHAR(50) NOT NULL,
    api_level INT NOT NULL,
    release_date DATE NOT NULL
);
