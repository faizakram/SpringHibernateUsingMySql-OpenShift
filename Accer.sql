/*
SQLyog Community v12.3.2 (64 bit)
MySQL - 5.5.53-log : Database - accer
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`accer` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `accer`;

/*Table structure for table `roles` */

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Role` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Role_Id` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `roles` */

insert  into `roles`(`Id`,`Role`) values 
(1,'ROLE_Admin'),
(2,'ROLE_Partner'),
(3,'ROLE_Instructor'),
(4,'ROLE_Student');

/*Table structure for table `user_profile` */

DROP TABLE IF EXISTS `user_profile`;

CREATE TABLE `user_profile` (
  `User_Email_Id` varchar(60) NOT NULL,
  `Name` varchar(60) NOT NULL,
  `DOB` varchar(20) DEFAULT NULL,
  `DOJ` varchar(60) NOT NULL,
  `MobileNo` varchar(10) DEFAULT NULL,
  `Skype` text,
  `LinkedIn` text,
  `Facebook` text,
  `Twitter` text,
  `GooglePlus` text,
  `Website` text,
  `Address` text,
  `ProfilePic` text,
  PRIMARY KEY (`User_Email_Id`),
  KEY `User_Email_Id` (`User_Email_Id`),
  KEY `ix_some_id` (`User_Email_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user_profile` */

insert  into `user_profile`(`User_Email_Id`,`Name`,`DOB`,`DOJ`,`MobileNo`,`Skype`,`LinkedIn`,`Facebook`,`Twitter`,`GooglePlus`,`Website`,`Address`,`ProfilePic`) values 
('faiz.krm@gmail.com','Faiz Akram',NULL,'01/14/2017','9990858653','faiz.akram37','https://www.linkedin.com/in/faiz-akram-7420b680','https://www.facebook.com/faizakram.java1.7','https://twitter.com/FaizKrm','https://plus.google.com/108780002047831238307/','http://faizakram.com/','New Delhi','profilePic/-1781454019.jpg');

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `User_Id` int(11) NOT NULL,
  `Role_Id` int(11) NOT NULL,
  KEY `FK143BF46A7214966` (`Role_Id`),
  KEY `FK143BF46AAC4C0D46` (`User_Id`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`User_Id`) REFERENCES `users` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`Role_Id`) REFERENCES `roles` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user_role` */

insert  into `user_role`(`User_Id`,`Role_Id`) values 
(18,1);

/*Table structure for table `user_verfication` */

DROP TABLE IF EXISTS `user_verfication`;

CREATE TABLE `user_verfication` (
  `Verification_Id` int(10) NOT NULL AUTO_INCREMENT,
  `User_Email_Id` varchar(60) NOT NULL,
  `Admin_Email_Verification` text,
  `User_Email_Verification` text,
  `Mobile_Verification` varchar(10) DEFAULT NULL,
  `Forgot_Password` text,
  `Account_Status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Verification_Id`),
  KEY `User_Email_Id` (`User_Email_Id`),
  CONSTRAINT `user_verfication_ibfk_1` FOREIGN KEY (`User_Email_Id`) REFERENCES `user_profile` (`User_Email_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;

/*Data for the table `user_verfication` */

insert  into `user_verfication`(`Verification_Id`,`User_Email_Id`,`Admin_Email_Verification`,`User_Email_Verification`,`Mobile_Verification`,`Forgot_Password`,`Account_Status`) values 
(38,'faiz.krm@gmail.com','Verified','Verified',NULL,NULL,'Continue');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `User_Email_Id` varchar(60) NOT NULL,
  `Password` varchar(60) NOT NULL,
  `Enable` tinyint(1) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `User_Id` (`Id`),
  UNIQUE KEY `Email_Id` (`User_Email_Id`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`User_Email_Id`) REFERENCES `user_profile` (`User_Email_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

/*Data for the table `users` */

insert  into `users`(`Id`,`User_Email_Id`,`Password`,`Enable`) values 
(18,'faiz.krm@gmail.com','$2a$10$phdHoBIKs0Ht/JHWsF/cqOpiDTW/5SR/jd2cb/L6L8AlNJA4KahYm',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
