### Reference
* https://www.javaguides.net/2019/03/login-form-using-jsp-servlet-jdbc-mysql-example.html
* https://freefrontend.com/css-login-forms/
* https://codepen.io/FlorinPop17/pen/vPKWjd

### Database Migration
```sql
CREATE DATABASE mysql_database;
-- Adminer 4.7.5 MySQL dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `users` (`id`, `name`, `email`, `password`) VALUES
(1,	'Arko Mandal',	'arko.unified@gmail.com',	'123456'),
(3,	'Bijay Das',	'bijay@gmail.com',	'123456');

-- 2020-10-05 14:34:31
```

### Run then Redirect to
http://localhost:8080/login-jsp-servlet/auth.jsp