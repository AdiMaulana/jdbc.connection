CREATE DATABASE android_db;
USE android_db;

CREATE TABLE android_version (
    id INT PRIMARY KEY AUTO_INCREMENT,
    version_name VARCHAR(50) NOT NULL,
    api_level INT NOT NULL,
    release_date DATE NOT NULL
);

INSERT INTO android_version (version_name, api_level, release_date)
VALUES 
    ('Android 1.0', 1, '2008-09-23'),
    ('Android 1.1', 2, '2009-02-09'),
    ('Android 1.5 Cupcake', 3, '2009-04-27'),
    ('Android 1.6 Donut', 4, '2009-09-15'),
    ('Android 2.0 Eclair', 5, '2009-10-26'),
    ('Android 2.2 Froyo', 8, '2010-05-20'),
    ('Android 2.3 Gingerbread', 9, '2010-12-06'),
    ('Android 3.0 Honeycomb', 11, '2011-02-11'),
    ('Android 4.0 Ice Cream Sandwich', 14, '2011-10-18'),
    ('Android 4.1 Jelly Bean', 16, '2012-06-27'),
    ('Android 4.4 KitKat', 19, '2013-10-31'),
    ('Android 5.0 Lollipop', 21, '2014-11-03'),
    ('Android 6.0 Marshmallow', 23, '2015-10-05'),
    ('Android 7.0 Nougat', 24, '2016-08-22'),
    ('Android 8.0 Oreo', 26, '2017-08-21'),
    ('Android 9.0 Pie', 28, '2018-08-06'),
    ('Android 10', 29, '2019-09-03'),
    ('Android 11', 30, '2020-09-08'),
    ('Android 12', 31, '2021-10-04'),
    ('Android 13', 33, '2022-08-15'),
    ('Android 14', 34, '2023-10-04');
