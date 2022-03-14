DROP DATABASE IF EXISTS `player_database`;
CREATE DATABASE `player_database`;
USE `player_database`;
DROP TABLE IF EXISTS `player`;
CREATE TABLE `player` (
                          `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
                          `NAME` varchar(50) NOT NULL,
                          `Age` int(11) NOT NULL,
                          `County` varchar(20) NOT NULL,
                          `Trophies` int(11) NOT NULL,
                          PRIMARY KEY  (`USER_ID`)
);

INSERT INTO player VALUES (null, "Stephen Clucton", 28, "Dublin", 8),
                          (null, "James McCarthy", 30, "Dublin" 4),
                          (null, "Bernard Brogan", 26, "Dubin", 6),
                          (null, "Colm Basquel", 23, "Dublin", 5),
                          (null, "Cormac Costello", 20, "Dublin", 4);
