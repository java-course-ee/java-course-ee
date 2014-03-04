# SQL Manager 2010 for MySQL 4.5.0.9
# ---------------------------------------
# Host     : localhost
# Port     : 3306
# Database : expomap


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

SET FOREIGN_KEY_CHECKS=0;

CREATE DATABASE `expomap`
    CHARACTER SET 'latin1'
    COLLATE 'latin1_swedish_ci';

USE `expomap`;

#
# Structure for the `project` table : 
#

CREATE TABLE `project` (
  `PROJECT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  PRIMARY KEY (`PROJECT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

#
# Structure for the `task` table : 
#

CREATE TABLE `task` (
  `TASK_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `PROJECT_ID` int(11) NOT NULL,
  PRIMARY KEY (`TASK_ID`),
  KEY `FK272D853F4E41A8` (`PROJECT_ID`),
  CONSTRAINT `FK272D853F4E41A8` FOREIGN KEY (`PROJECT_ID`) REFERENCES `project` (`PROJECT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

#
# Structure for the `user` table : 
#

CREATE TABLE `user` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMAIL` varchar(255) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=latin1;

#
# Structure for the `users_tasks` table : 
#

CREATE TABLE `users_tasks` (
  `USER_ID` int(11) NOT NULL,
  `TASK_ID` int(11) NOT NULL,
  KEY `FKADD16E575326420C` (`USER_ID`),
  KEY `FKADD16E574A2FCC` (`TASK_ID`),
  CONSTRAINT `FKADD16E574A2FCC` FOREIGN KEY (`TASK_ID`) REFERENCES `task` (`TASK_ID`),
  CONSTRAINT `FKADD16E575326420C` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for the `project` table  (LIMIT 0,500)
#

INSERT INTO `project` (`PROJECT_ID`, `NAME`) VALUES 
  (19,'Project One'),
  (20,'Project Two'),
  (21,'Project Three');
COMMIT;

#
# Data for the `task` table  (LIMIT 0,500)
#

INSERT INTO `task` (`TASK_ID`, `NAME`, `PROJECT_ID`) VALUES 
  (8,'Task11',19),
  (9,'Task12',19),
  (10,'Task21',20),
  (11,'Task22',20),
  (12,'Task31',21),
  (13,'Task32',21);
COMMIT;

#
# Data for the `user` table  (LIMIT 0,500)
#

INSERT INTO `user` (`USER_ID`, `EMAIL`, `NAME`) VALUES 
  (58,'ivanov@gmail.com','Ivanov Ivan'),
  (59,'petrov@gmail.com','Petrov Petr'),
  (60,'sidorov@gmail.com','Sidorov Sidr');
COMMIT;

#
# Data for the `users_tasks` table  (LIMIT 0,500)
#

INSERT INTO `users_tasks` (`USER_ID`, `TASK_ID`) VALUES 
  (60,9),
  (58,8),
  (59,8),
  (58,10),
  (60,10),
  (59,11),
  (60,11),
  (59,12),
  (60,12),
  (58,13),
  (59,13),
  (60,13);
COMMIT;



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;