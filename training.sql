-- Adminer 4.2.1 MySQL dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_address` varchar(255) DEFAULT NULL,
  `emp_mobile_nos` varchar(255) DEFAULT NULL,
  `emp_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

INSERT INTO `employee` (`emp_id`, `emp_address`, `emp_mobile_nos`, `emp_name`) VALUES
(1,	'Airoli',	'369852147',	'Mahesh'),
(2,	'Airoli',	'369852147',	'Mahesh');

DROP TABLE IF EXISTS `Employee`;
CREATE TABLE `Employee` (
  `empid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `empaddress` varchar(255) DEFAULT NULL,
  `empage` int(11) DEFAULT NULL,
  `empname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`empid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

INSERT INTO `Employee` (`empid`, `name`, `age`, `salary`, `address`, `empaddress`, `empage`, `empname`) VALUES
(3,	'Vishwas',	24,	25000,	'Airoli',	NULL,	NULL,	NULL),
(4,	'Ashwini',	22,	23500,	'Thane',	NULL,	NULL,	NULL);

DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

INSERT INTO `login` (`id`, `username`, `password`) VALUES
(1,	'devendra',	'yadav'),
(5,	'devendra@gmail.com',	'yadav'),
(2,	'test@test.com',	'123456');

DROP TABLE IF EXISTS `Reader`;
CREATE TABLE `Reader` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Email` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `Reader_Subs`;
CREATE TABLE `Reader_Subs` (
  `reader_ID` int(11) NOT NULL,
  `subscriptions_ID` int(11) NOT NULL,
  KEY `FK_gocq88xucrmqy5virp20s34d` (`subscriptions_ID`),
  KEY `FK_pui4emt6bugjbw6l729s0om1c` (`reader_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `RegisteredUser`;
CREATE TABLE `RegisteredUser` (
  `regId` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(25) NOT NULL,
  `lastName` varchar(25) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `phone` varchar(12) NOT NULL,
  `email` varchar(40) NOT NULL,
  `password` varchar(25) NOT NULL,
  PRIMARY KEY (`regId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

INSERT INTO `RegisteredUser` (`regId`, `firstName`, `lastName`, `gender`, `phone`, `email`, `password`) VALUES
(8,	'MAHESH',	'SURYVANSHI',	'Male',	'4569871230',	'devendra@gmail.com',	'************'),
(1,	'Test',	'Test',	'Male',	'9167692709',	'test@test.com',	'************');

DROP TABLE IF EXISTS `Subscription`;
CREATE TABLE `Subscription` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SubName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `subscription`;
CREATE TABLE `subscription` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SubName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

INSERT INTO `subscription` (`ID`, `SubName`) VALUES
(1,	'Entertainment'),
(2,	'Horor');

DROP TABLE IF EXISTS `Subscription_Reader`;
CREATE TABLE `Subscription_Reader` (
  `Subscription_ID` int(11) NOT NULL,
  `reader_ID` int(11) NOT NULL,
  KEY `FK_eoj5xa6btqwv2jfgsmlw1ci5e` (`reader_ID`),
  KEY `FK_5lnomqswgc4y52djhp4huw2rb` (`Subscription_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `subscription_Reader`;
CREATE TABLE `subscription_Reader` (
  `subscription_ID` int(11) NOT NULL,
  `reader_ID` int(11) NOT NULL,
  KEY `FK_hibh5y0r9kojdimyf2bp8ga5e` (`reader_ID`),
  KEY `FK_cvuacw1o65n3rdff5cuvmst2b` (`subscription_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` varchar(100) NOT NULL DEFAULT '',
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

INSERT INTO `test` (`id`, `name`) VALUES
('1',	'Devendra'),
('',	'Test');

DROP TABLE IF EXISTS `testing`;
CREATE TABLE `testing` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

INSERT INTO `testing` (`id`, `name`) VALUES
(2,	'BCD'),
(1,	'ABC');

DROP TABLE IF EXISTS `USERDETAILS`;
CREATE TABLE `USERDETAILS` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(255) DEFAULT NULL,
  `VEHICLE_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`),
  KEY `FK_anfgri84gjc8m14th6ba6nhok` (`VEHICLE_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

INSERT INTO `USERDETAILS` (`USER_ID`, `USER_NAME`, `VEHICLE_ID`) VALUES
(1,	'Devendra',	1),
(2,	'Devendra',	2),
(3,	'Jitendra',	2);

DROP TABLE IF EXISTS `UserDetails`;
CREATE TABLE `UserDetails` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) DEFAULT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `city` varchar(25) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `phone` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

INSERT INTO `UserDetails` (`user_id`, `first_name`, `last_name`, `gender`, `city`, `email`, `phone`) VALUES
(1,	'Sandeep',	'Sandeep',	'Male',	'Allahabad',	'12343@gmail.com',	'123456987'),
(2,	'Devendra',	'Yadav',	'Male',	'Kolkata',	NULL,	NULL),
(3,	'Devendra',	'Yadav',	'Male',	'Mumbai',	NULL,	NULL),
(4,	'Devendra',	'Yadav',	'Male',	'Delhi',	NULL,	NULL),
(5,	'Devendra',	'Yadav',	'Male',	'Chennai',	NULL,	NULL),
(6,	'Devendra',	'Yadav',	'Male',	'Kolkata',	'',	''),
(7,	'Ravindra',	'Yadav',	'Male',	'Delhi',	NULL,	NULL),
(8,	'Test',	'Test',	'Male',	'Delhi',	'test@test.com',	'9876543210');

DROP TABLE IF EXISTS `VEHICLE`;
CREATE TABLE `VEHICLE` (
  `VEHICLE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `VEHICLE_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`VEHICLE_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

INSERT INTO `VEHICLE` (`VEHICLE_ID`, `VEHICLE_NAME`) VALUES
(1,	'BMW'),
(2,	'Ferrari');

-- 2017-01-03 06:33:52
